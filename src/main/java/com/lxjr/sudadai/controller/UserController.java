package com.lxjr.sudadai.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.entity.RepeatBetaUser;
import com.lxjr.sudadai.entity.Target;
import com.lxjr.sudadai.entity.User;
import com.lxjr.sudadai.service.IRepeatBetaUserService;
import com.lxjr.sudadai.service.ITargetService;
import com.lxjr.sudadai.service.IUserInfoService;
import com.lxjr.sudadai.service.IUserService;
import com.lxjr.sudadai.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/sudadai/user")
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @Resource
    private IUserInfoService userInfoService;

    @Resource
    private ITargetService targetService;

    @Resource
    private IRepeatBetaUserService repeatBetaUserService;

    /**
     * 手机验证码登录
     * @param ticket 手机验证码
     * @param mobile 手机号
     * @param source 用户来源
     * @param sourceUrl 来源url
     * @return
     */
    @RequestMapping(value="/loginByTicket",method= RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String loginByTicket(String ticket,String mobile,String source,String sourceUrl) {
        JSONObject returnJson = new JSONObject();
        try{
            // 检查短信验证码并获得返回结果
            String result = Validate.validateTicket(ticket);
            // 校验返回结果
            if(!BaseConstant.SUCCESS.equals(result)) {
                return getReturnValidateErrJson(result);
            }
            // 生成新的uuid
            String uuid = Random.getRandomString(50);
            // 判断当前用户是否已存在
            User user = userService.queryUserByMobile(mobile);
            if(user == null) {
                user = new User();
                user.setMobile(mobile);
                user.setPassword("");
                // 默认为-1
                user.setFirstTarget(BaseConstant.DEDAULT_FIRST_TARGET);
            }
            user.setUuid(uuid);
            // 用户验证码登录
            userService.saveOrUpdateUser(user,source);
            // 将uuid放到cookie中
            setUUIDInCookie(uuid,mobile);
            logger.info("userId:{},登陆成功",user.getId());
            // 检查用户是否有用户信息
            if(checkUserInfo(user.getId())) {
                return ReturnUtil.getReturnCheckJson(user.getId());
            }
            // 准备返回给前端的数据
            List<Target> targetList = targetService.queryTargetByUserId(user.getId(),source, sourceUrl);
            // 返回前端数据
            returnJson.put("mobile",user.getMobile());
            returnJson.put(BaseConstant.SUCCESS,true);
            returnJson.put("targetList",targetList);
            returnJson.put(BaseConstant.USER_ID,user.getId());
            returnJson.put(BaseConstant.USER_INFO,true);
        }catch(Exception e) {
            logger.error(BaseConstant.LOG_ERR_MSG+" loginByTicket error:"+e,e);
            return ReturnUtil.getReturnErrJson();
        }
        return returnJson.toJSONString();
    }

    /**
     * 将用户uuid放入cookie
     * @param uuid uuid
     * @param mobile 用户手机号
     */
    private void setUUIDInCookie(String uuid,String mobile) {
        // 将用户信息放入cookie
        HttpSession session = CommonHandle.getSession();
        session.setAttribute("mobile", mobile);
        //将用户ID放入COOKIE中
        HttpServletResponse response = CommonHandle.getResponse();

        Cookie passport = new Cookie("uuid",uuid);
        logger.info("用户uuid放入cookie中,uuid:{}",uuid);
        //设定有效时间  以秒(s)为单位
        passport.setMaxAge(25920000);
        //设置Cookie路径和域名
        passport.setPath("/") ;
        response.addCookie(passport);
    }

    /**
     * 自动登录
     * @param source 来源
     * @param sourceUrl 来源url
     * @return
     */
    @RequestMapping(value="/autoLogin",method= RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String autoLogin(String source,String sourceUrl) {
        JSONObject returnJson = new JSONObject();
        try{
            String uuid = CommonHandle.getCookieValue("uuid");
            logger.info("uuid为空:{}",uuid == null);
            // 判断cookie中是否存在uuid
            if(uuid == null) {
                returnJson.put(BaseConstant.SUCCESS,false);
                return returnJson.toJSONString();
            }
            logger.info("uuid:{}",uuid);
            // 通过uuid获取用户
            User user = userService.queryUserByUUID(uuid);
            logger.info("user为空:{}",user == null);
            if(user == null) {
                returnJson.put(BaseConstant.SUCCESS,false);
                return returnJson.toJSONString();
            }
            logger.info("userId:{}",user.getId());
            String mobile = user.getMobile();
            Long userId = user.getId();
            // 检查用户是否已填用户信息
            if(checkUserInfo(user.getId())) {
                return ReturnUtil.getReturnCheckJson(user.getId());
            }

            if(user.getSourceId() == 1) {
                if(!"beta".equals(source)) {
                    //日志记录
                    logger.info("beta注册，beta2访问，记录。。");
                    RepeatBetaUser rp = new RepeatBetaUser();
                    rp.setMobile(mobile);
                    rp.setSourceId(1L);
                    repeatBetaUserService.saveRepeatBetaUser(rp);
                }
            } else if(user.getSourceId() == 2) {
                if(!"beta2".equals(source)){
                    //日志记录
                    logger.info("beta2注册，beta访问，记录。。");
                    RepeatBetaUser rp = new RepeatBetaUser();
                    rp.setMobile(mobile);
                    rp.setSourceId(2L);
                    repeatBetaUserService.saveRepeatBetaUser(rp);
                }
            }
            // 返回前端list
            List<Target> targetList = targetService.queryTargetByUserId(user.getId(), source, sourceUrl);
            returnJson.put(BaseConstant.SUCCESS,true);
            returnJson.put("targetList",targetList);
        } catch(Exception e) {
            logger.error(BaseConstant.LOG_ERR_MSG+" autoLogin error:"+e,e);
            return ReturnUtil.getReturnErrJson();
        }

        return returnJson.toJSONString();
    }

    /**
     * 检查用户是否已填用户信息
     * @return
     */
    private Boolean checkUserInfo(Long userId) {
        // 检查用户是否有用户信息
        return userInfoService.getUserInfoCount(userId) == 0;
    }

    /**
     * 校验图片验证码
     * @param mobile 用户手机号
     * @param code 图片验证码
     * @return
     */
    @RequestMapping(value="/checkPicVCode",method= RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String checkPicVCode(String mobile, String code) {
        JSONObject returnJson = new JSONObject();
        try{
            // 检查图片验证码并获得返回结果
            String result = Validate.validateVCode(code);
            // 校验返回结果
            if(!BaseConstant.SUCCESS.equals(result)) {
                return getReturnValidateErrJson(result);
            }

            String random = Random.getRandom();

            String ip = "";
            try {
                ip = getUserIp(CommonHandle.getRequest());
            } catch (Exception e) {
                logger.error(BaseConstant.ERROR_MAG+" getUserIp error:"+e,e);
            }

            HttpSession session = CommonHandle.getSession();
            Boolean success;
            int sendCount = session.getAttribute(ip) == null ? 1 :Integer.parseInt(session.getAttribute(ip).toString());
            if(sendCount <= 3000){
                session.setAttribute("ticket", random);
                logger.info(mobile+"-------------"+random);
                String content = "验证码："+random;
                session.setAttribute(ip, ++sendCount);
                SendMessage.send(content,mobile);
                success = true;
            }else{
                success = false;
            }
            returnJson.put(BaseConstant.SUCCESS,success);
        }catch(Exception e) {
            logger.error(BaseConstant.LOG_ERR_MSG+" checkPicVCode error:"+e,e);
            return ReturnUtil.getReturnErrJson();
        }

        return returnJson.toJSONString();
    }

    /**
     * 获得验证错误json
     * @param result 错误原因
     * @return
     */
    private String getReturnValidateErrJson(String result) {
        JSONObject returnJson = new JSONObject();
        returnJson.put(BaseConstant.REASON,result);
        returnJson.put(BaseConstant.SUCCESS,false);
        return returnJson.toJSONString();
    }

    /**
     * 获取Ip
     * @param request 请求
     * @return
     * @throws Exception
     */
    private static String getUserIp(HttpServletRequest request) throws Exception {
        String ip = "";

        if(request.getHeader("x-forwarded-for")!=null&&(!request.getHeader("x-forwarded-for").trim().equals(""))){
            ip = request.getHeader("x-forwarded-for").split(",")[0];
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
