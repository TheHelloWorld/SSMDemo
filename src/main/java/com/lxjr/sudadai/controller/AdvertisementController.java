package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.Advertisement;
import com.lxjr.sudadai.service.IAdvertisementService;
import com.lxjr.sudadai.utils.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sudadai/ad")
@Controller
public class AdvertisementController {

	private static final Logger logger = LoggerFactory.getLogger(AdvertisementController.class);

	@Resource
	private IAdvertisementService advertisementService;

	/**
	 * 获取广告list
	 *
	 * @return
	 */
	@RequestMapping(value = "/queryAd", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryAd() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<Advertisement> adList = advertisementService.queryAllAdvertisement();
			jsonObject.put(BaseConstant.SUCCESS, true);
			jsonObject.put("adList", adList);
		} catch (Exception e) {
			logger.error(BaseConstant.LOG_ERR_MSG + " queryAd error:" + e, e);
			return ReturnUtil.getReturnErrJson();
		}

		return jsonObject.toJSONString();
	}
}
