package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.Source;
import com.lxjr.sudadai.entity.Target;
import com.lxjr.sudadai.entity.User;
import com.lxjr.sudadai.service.ISourceService;
import com.lxjr.sudadai.service.ITargetService;
import com.lxjr.sudadai.service.IUserService;
import com.lxjr.sudadai.service.IUserToService;
import com.lxjr.sudadai.utils.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/sudadai/userTo")
@Controller
public class UserToController {

	private static final Logger logger = LoggerFactory.getLogger(UserToController.class);

	@Resource
	private ITargetService targetService;

	@Resource
	private IUserService userService;

	@Resource
	private ISourceService sourceService;

	@Resource
	private IUserToService userToService;

	/**
	 * 记录用户去向
	 *
	 * @param targetId 目标平台Id
	 * @param mobile   手机号
	 * @return
	 */
	@RequestMapping(value = "/userLeave", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String userLeave(Long targetId, String mobile) {
		JSONObject returnJson = new JSONObject();
		try {
			String url;
			// 用户去向
			Target target = targetService.getTargetById(targetId);

			if (target == null) {
				logger.warn("target为空,targetId:{}", targetId);
				return getUserLeaveErrJson();
			}

			// 用户信息
			User user = userService.queryUserByMobile(mobile);

			if (user == null) {
				logger.warn("user为空,mobile:{}", mobile);
				return getUserLeaveErrJson();
			}
			// 用户来源
			Source source = sourceService.querySourceById(user.getSourceId());

			userToService.updateUserAndSaveUserTo(target, user);

			//返回url
			if (target.getType() == 2) {
				if (target.getId() == 1) {
					if (source.getId() == 1) {//马上
						url = target.getUrl().replace("sudadai5", "sudadai1");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("sudadai5", "sudadai2");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("sudadai5", "sudadai3");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("sudadai5", "sudadai4");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 9) {//先花花
					if (source.getId() == 1) {
						url = target.getUrl().replace("1490", "22");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("1490", "1487");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("1490", "1488");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("1490", "1489");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 10) {//卡卡贷
					if (source.getId() == 1) {
						url = target.getUrl().replace("sudadai05", "sudadai01");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("sudadai05", "sudadai02");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("sudadai05", "sudadai03");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("sudadai05", "sudadai04");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 11) {//闪电贷款
					if (source.getId() == 1) {
						url = target.getUrl().replace("10604", "10600");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("10604", "10601");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("10604", "10602");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("10604", "10603");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 14) {//秒白条
					if (source.getId() == 1) {
						url = target.getUrl().replace("sudadai", "sudadai1");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("sudadai", "sudadai2");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("sudadai", "sudadai3");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("sudadai", "sudadai4");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 15) {//信而富
					if (source.getId() == 1) {
						url = target.getUrl().replace("BJGR005", "BJGR001");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("BJGR005", "BJGR002");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("BJGR005", "BJGR003");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("BJGR005", "BJGR004");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 16) {//万卡
					if (source.getId() == 1) {
						url = "https://onecard.9fbank.com/wkCubeNew/#/register?proId=sddb4034deb50851505b449cc22047372a5";
					} else if (source.getId() == 2) {
						url = "https://onecard.9fbank.com/wkCubeNew/#/register?proId=sdd192d9c2102e6ea00abd46044e1647deb7";
					} else if (source.getId() == 3) {
						url = "https://onecard.9fbank.com/wkCubeNew/#/register?proId=ssd28b92fb13709992f9ae12ff0246b51efe";
					} else if (source.getId() == 40) {
						url = "https://onecard.9fbank.com/wkCubeNew/#/register?proId=sdd3b91edeabd6e6a0e1a630564484c5235c";
					} else {
						url = "https://onecard.9fbank.com/wkCubeNew/#/register?proId=sdd489fcfeb08ae6b85685df699f61c9f519";
					}
				} else if (target.getId() == 17) {//现金白卡
					if (source.getId() == 1) {
						url = target.getUrl();
					} else if (source.getId() == 2) {
						url = "http://t.cn/RX8N221";
					} else if (source.getId() == 3) {
						url = "http://t.cn/RX8NXTE";
					} else if (source.getId() == 40) {
						url = "http://t.cn/RX8N1bc";
					} else {
						url = "http://t.cn/RX8pahN";
					}
				} else if (target.getId() == 20) {//美借
					if (source.getId() == 1) {
						url = target.getUrl().replace("sudd5", "sudd1");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("sudd5", "sudd2");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("sudd5", "sudd3");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("sudd5", "sudd4");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 21) {//中原银行
					if (source.getId() == 1) {
						url = target.getUrl().replace("5", "1");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("5", "2");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("5", "3");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("5", "4");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 26) {//快来贷
					if (source.getId() == 1) {
						url = target.getUrl().replace("sudadai05", "sudadai");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("sudadai05", "sudadai02");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("sudadai05", "sudadai03");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("sudadai05", "sudadai04");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 27) {//有借
					if (source.getId() == 1) {
						url = target.getUrl().replace("youjie507-microsite", "youjie503-microsite");
					} else if (source.getId() == 2) {
						url = target.getUrl().replace("youjie507-microsite", "youjie504-microsite");
					} else if (source.getId() == 3) {
						url = target.getUrl().replace("youjie507-microsite", "youjie505-microsite");
					} else if (source.getId() == 40) {
						url = target.getUrl().replace("youjie507-microsite", "youjie506-microsite");
					} else {
						url = target.getUrl();
					}
				} else if (target.getId() == 23) {
					if (source.getId() == 40) {
						url = "http://m.geedai.com/activity/reg/register.html?utm_source=wap_weijuguanggao3";
					} else {
						url = "http://m.geedai.com/activity/reg/register.html?utm_source=wap_weijuguanggao5";
					}
				} else if (target.getId() == 24) {
					if (source.getId() == 40) {
						url = "https://c.lattebank.com/hbzc/a1/6?channel=jiean10";
					} else {
						url = "https://c.lattebank.com/hbzc/a1/6?channel=jiean09";
					}
				} else if (target.getId() == 25) {
					if (source.getId() == 40) {
						url = "http://click.xuezhionline.com/union/KeRmjH3XSr4fnhMEES2OEA%3D%3D";
					} else {
						url = "http://click.xuezhionline.com/union/KeRmjH3XSr4a8W2wwPVSjA%3D%3D";
					}
				} else {
					try {
						url = target.getUrl().replace("sourceCode", source.getSourceCode());
					} catch (Exception e) {
						e.printStackTrace();
						url = "www.baidu.com";
					}
				}
			} else {
				url = target.getUrl();
			}
			logger.info("target url:{}", url);
			returnJson.put("url", url);
			returnJson.put(BaseConstant.SUCCESS, true);
		} catch (Exception e) {
			logger.error(BaseConstant.LOG_ERR_MSG + " userLeave error:" + e, e);
			return ReturnUtil.getReturnErrJson();
		}

		return returnJson.toJSONString();
	}

	/**
	 * 获得用户离开错误Json
	 *
	 * @return
	 */
	private String getUserLeaveErrJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("url", "www.baidu.com");
		jsonObject.put(BaseConstant.SUCCESS, true);
		return jsonObject.toJSONString();
	}
}
