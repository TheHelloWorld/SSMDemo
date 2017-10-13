package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.Target;
import com.lxjr.sudadai.service.ITargetService;
import com.lxjr.sudadai.utils.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sudadai/target")
@Controller
public class TargetController {

	private static final Logger logger = LoggerFactory.getLogger(TargetController.class);

	@Resource
	private ITargetService targetService;

	/**
	 * 获得默认平台list
	 *
	 * @param source    用户来源
	 * @param sourceUrl 来源url
	 * @return
	 */
	@RequestMapping(value = "/queryDefaultTarget", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryDefaultTarget(String source, String sourceUrl) {
		JSONObject jsonObject = new JSONObject();
		try {
			List<Target> targetList = targetService.queryDefaultTarget(source, sourceUrl);
			jsonObject.put(BaseConstant.SUCCESS, true);
			jsonObject.put("targetList", targetList);
		} catch (Exception e) {
			logger.error(BaseConstant.LOG_ERR_MSG + " queryDefaultTarget error:" + e, e);
			return ReturnUtil.getReturnErrJson();
		}
		return jsonObject.toJSONString();
	}
}
