package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.Tag;
import com.lxjr.sudadai.service.ITagService;
import com.lxjr.sudadai.utils.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sudadai/tag")
@Controller
public class TagController {

	private static final Logger logger = LoggerFactory.getLogger(TagController.class);

	@Resource
	private ITagService tagService;

	/**
	 * 获得所有标签
	 *
	 * @return
	 */
	@RequestMapping(value = "/getAllTag", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllTag() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<Tag> tagList = tagService.queryAllTag();
			jsonObject.put(BaseConstant.SUCCESS, true);
			jsonObject.put("tagList", tagList);
		} catch (Exception e) {
			logger.error(BaseConstant.LOG_ERR_MSG + " getAllTag error:" + e, e);
			return ReturnUtil.getReturnErrJson();
		}
		return jsonObject.toJSONString();
	}

}
