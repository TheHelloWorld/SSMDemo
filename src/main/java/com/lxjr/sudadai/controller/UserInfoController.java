package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.Target;
import com.lxjr.sudadai.entity.UserInfo;
import com.lxjr.sudadai.entity.UserTag;
import com.lxjr.sudadai.service.ITagService;
import com.lxjr.sudadai.service.ITargetService;
import com.lxjr.sudadai.service.IUserInfoService;
import com.lxjr.sudadai.service.IUserService;
import com.lxjr.sudadai.utils.IdCardNoValidator;
import com.lxjr.sudadai.utils.ReturnUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("/sudadai/userInfo")
@Controller
public class UserInfoController {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@Resource
	private IUserInfoService userInfoService;

	@Resource
	private ITargetService targetService;

	@Resource
	private ITagService tagService;

	@Resource
	private IUserService userService;

	/**
	 * 储存用户信息及标签
	 *
	 * @param userId    用户Id
	 * @param realName  真实姓名
	 * @param idCardNo  身份证号
	 * @param userTags  用户选择标签
	 * @param source    用户来源
	 * @param sourceUrl 来源url
	 * @return
	 */
	@RequestMapping(value = "/saveUserInfoAndTags", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveUserInfoAndTags(Long userId, String realName, String idCardNo, String userTags, String source,
	                                  String sourceUrl) {
		JSONObject json = new JSONObject();
		try {

			String result = checkUserInfo(userId, realName, idCardNo, userTags);
			// 检查参数
			if (!BaseConstant.SUCCESS.equals(result)) {
				return ReturnUtil.getReasonReturnJson(result);
			}
			logger.info("userTags:{}", userTags);
			JSONArray jsonArray;
			// 检验userTags格式
			try {
				jsonArray = JSONArray.parseArray(userTags);
			} catch (Exception e) {
				logger.error("userTags格式非法,userTags:{}", userTags);
				return ReturnUtil.getReasonReturnJson("userTags格式非法");
			}

			// 检查用户是否合法
			if (userService.queryUserById(userId) == null) {
				logger.warn("当前用户不存在,userId:{}", userId);
				return ReturnUtil.getReasonReturnJson("当前用户不存在");
			}
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(userId);
			userInfo.setIdCardNo(idCardNo);
			userInfo.setRealName(realName);

			List<UserTag> userTagList = new ArrayList<>(jsonArray.size());
			// 标签去重
			Set<String> tagSet = new HashSet<>(jsonArray.size());
			int order = 1;
			// 遍历用户选择的标签
			for (int i = 0; i < jsonArray.size(); i++) {

				String tagCode = String.valueOf(jsonArray.get(i));
				// 如果标签不重复
				if (tagSet.add(tagCode)) {
					// 判断标签是否存在
					if (tagService.getCountByTagCode(tagCode) == 0) {
						logger.info("userId:{} 非法标签code:{}", userId, tagCode);
						continue;
					}
					UserTag userTag = new UserTag();
					userTag.setTagCode(String.valueOf(jsonArray.get(i)));
					userTag.setUserId(userId);
					userTag.setSelectOrder(order);
					userTagList.add(userTag);
					order++;
				}
			}

			tagSet.clear();

			if (userTagList.isEmpty()) {
				throw new RuntimeException("userTagList is empty");
			}

			// 存储用户信息
			String msg = userInfoService.saveUserInfoAndTags(userInfo, userTagList);

			if (!BaseConstant.SUCCESS.equals(msg)) {
				return ReturnUtil.getReasonReturnJson("msg");
			}

			// 根据用户选择标签对平台进行排序
			List<Target> targetList = targetService.queryTargetByUserId(userId, source, sourceUrl);
			json.put(BaseConstant.SUCCESS, true);
			json.put("targetList", targetList);
		} catch (Exception e) {
			logger.error(BaseConstant.LOG_ERR_MSG + " saveUserInfoAndTags error:" + e, e);
			return ReturnUtil.getReturnErrJson();
		}
		return json.toJSONString();
	}

	/**
	 * 检查用户信息
	 *
	 * @return
	 */
	private String checkUserInfo(Long userId, String realName, String idCardNo, String userTags) {
		if (userId == null) {
			return "当前未登录";
		}
		if (StringUtils.isBlank(realName)) {
			return "真实姓名为空";
		}
		if (StringUtils.isBlank(idCardNo)) {
			return "身份证号为空";
		}
		// 验证身份证号
		if (!IdCardNoValidator.isValidatedAllIdCardNo(idCardNo)) {
			logger.info("validateIdCardNo msg:拦截的身份证号,userId:{},idCardNo:{}", userId, idCardNo);
			return "请填写正确的身份证号";
		}
		if (StringUtils.isBlank(userTags)) {
			return "用户标签为空";
		}

		return BaseConstant.SUCCESS;
	}

}
