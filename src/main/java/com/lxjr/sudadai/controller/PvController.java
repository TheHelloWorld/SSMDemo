package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.Source;
import com.lxjr.sudadai.service.IPvService;
import com.lxjr.sudadai.service.ISourceService;
import com.lxjr.sudadai.utils.ReturnUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/sudadai/pv")
@Controller
public class PvController {

    private static final Logger logger = LoggerFactory.getLogger(PvController.class);

    @Resource
    private IPvService pvService;

    @Resource
    private ISourceService sourceService;

    /**
     * 记录用户来源
     * @param source 用户来源
     * @return
     */
    @RequestMapping(value="/pv",method= RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String pv(String source) {
        JSONObject returnJson = new JSONObject();
        try {
            if(StringUtils.isBlank(source)) {
                source = "or001";
            }
            Source entity = sourceService.querySourceByName(source);
            if(entity == null) {
                logger.warn("source 为空,sourceName:{}",source);
                return returnJson.toJSONString();
            }
            pvService.savePV(entity.getId());
            returnJson.put(BaseConstant.SUCCESS,true);
        } catch(Exception e) {
            logger.error(BaseConstant.LOG_ERR_MSG+" pv error:"+e,e);
            return ReturnUtil.getReturnErrJson();
        }

        return returnJson.toJSONString();
    }

}
