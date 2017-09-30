package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.dao.UserInfoDAO;
import com.lxjr.sudadai.dao.UserTagDAO;
import com.lxjr.sudadai.entity.UserInfo;
import com.lxjr.sudadai.entity.UserTag;
import com.lxjr.sudadai.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    private UserInfoDAO userInfoDAO;

    @Resource
    private UserTagDAO userTagDAO;

    /**
     * 根据用户Id获得用户信息数量
     * @param userId 用户Id
     * @return
     */
    @Override
    public Integer getUserInfoCount(Long userId) {
        return userInfoDAO.getUserInfoCount(userId);
    }

    /**
     * 储存用户信息及标签
     * @param userInfo 用户信息
     * @param userTagList 用户标签
     */
    @Override
    public String saveUserInfoAndTags(UserInfo userInfo, List<UserTag> userTagList) {
        // 用户信息数量
        Integer userInfoCount = userInfoDAO.getUserInfoCountByIdCardNoAndUserId(userInfo.getIdCardNo(),
                userInfo.getUserId());
        // 用户标签数量
        Integer userTagCount = userTagDAO.getUserTagsCountByUserId(userInfo.getUserId());
        // 判断用户信息是否已提交
        if(userInfoCount > 0 || userTagCount > 0) {
            logger.info("user_info_repeat:userId:"+userInfo.getUserId()+",userInfoCount:"+userInfoCount+",userTagCount:"+userTagCount);
            return BaseConstant.USER_INFO_REPEAT;
        }
        // 储存用户信息
        userInfoDAO.saveUserInfo(userInfo);
        // 储存用户标签
        for(UserTag userTag : userTagList) {
            userTagDAO.saveUserTag(userTag);
        }
        return BaseConstant.SUCCESS;
    }
}
