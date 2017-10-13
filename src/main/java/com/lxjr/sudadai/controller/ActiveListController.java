package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.ActiveInfo;
import com.lxjr.sudadai.service.IActiveListService;
import com.lxjr.sudadai.service.IUserActiveService;
import com.lxjr.sudadai.utils.ReturnUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/sudadai/active")
@Controller
public class ActiveListController {

	private static final Logger logger = LoggerFactory.getLogger(ActiveListController.class);

	@Resource
	private IActiveListService activeListService;

	@Resource
	private IUserActiveService userActiveService;

	/**
	 * 根据活动code获得活动信息
	 *
	 * @param code       微信code
	 * @param activeCode 活动code
	 * @return
	 */
	@RequestMapping(value = "/queryActiveInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryActiveInfo(String code, String activeCode) {

		JSONObject returnJson = new JSONObject();
		try {

			if (StringUtils.isBlank(activeCode)) {
				return getActiveErrReturnJson();
			}
			// 根据活动code获得获得信息
			ActiveInfo activeInfo = activeListService.queryActiveInfo(activeCode);
			if (activeInfo == null) {
				return getActiveErrReturnJson();
			}
			// 异步查询用户信息并储存用户活动
			userActiveService.queryWinXinInfoAndSaveUserActive(code, activeCode);
			returnJson.put(BaseConstant.SUCCESS, true);
		} catch (Exception e) {
			logger.error(BaseConstant.LOG_ERR_MSG + " queryActiveInfo error:" + e, e);
			return ReturnUtil.getReturnErrJson();
		}

		return returnJson.toJSONString();
	}

	/**
	 * 获得获得错误Json
	 *
	 * @return
	 */
	private String getActiveErrReturnJson() {
		JSONObject json = new JSONObject();
		json.put(BaseConstant.SUCCESS, false);
		json.put(BaseConstant.REASON, "暂无活动");
		return json.toJSONString();
	}
}
