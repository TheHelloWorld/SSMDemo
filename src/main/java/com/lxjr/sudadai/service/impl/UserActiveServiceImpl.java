package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.bean.WxUserInfo;
import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.dao.UserActiveDAO;
import com.lxjr.sudadai.entity.UserActive;
import com.lxjr.sudadai.service.IUserActiveService;
import com.lxjr.sudadai.utils.WxTokenHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("userActiveService")
public class UserActiveServiceImpl implements IUserActiveService {

    @Resource
    private UserActiveDAO userActiveDAO;

    private static final Logger logger = LoggerFactory.getLogger(UserActiveServiceImpl.class);

    /** 线程池大小 **/
    private static final int poolSize = 15;

    /** 初始化全局唯一线程池 **/
    private final static ExecutorService pool = Executors.newFixedThreadPool(poolSize);

    /**
     * 异步查询用户微信信息并储存用户活动记录(因查询微信信息时网络请求,且只有一个储存操作,所以不开启事务)
     * @param code 用户微信code
     * @param activeCode 活动code
     */
    @Override
    public void queryWinXinInfoAndSaveUserActive(final String code,final String activeCode) {
        // 匿名内部类
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    // 获取用户微信信息
                    WxUserInfo wxUserInfo = WxTokenHelper.getUserInfo(code);
                    // 判断是否获取成功若成功则储存
                    if(wxUserInfo != null && !StringUtils.isBlank(wxUserInfo.getOpenid())){
                        UserActive userActive = new UserActive();
                        userActive.setOpenId(wxUserInfo.getOpenid());
                        userActive.setUnionId(wxUserInfo.getUnionid());
                        userActive.setActiveCode(activeCode);
                        userActiveDAO.saveUserActive(userActive);
                    }
                }catch(Exception err) {
                    logger.error(BaseConstant.LOG_ERR_MSG+" queryWinXinInfoAndSaveUserActive error:"+err,err);
                }
            }
        });
    }
}
