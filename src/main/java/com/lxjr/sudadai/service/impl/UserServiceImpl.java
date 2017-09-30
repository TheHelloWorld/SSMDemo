package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.dao.SourceDAO;
import com.lxjr.sudadai.dao.UserDAO;
import com.lxjr.sudadai.entity.Source;
import com.lxjr.sudadai.entity.User;
import com.lxjr.sudadai.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDAO userDAO;

    @Resource
    private SourceDAO sourceDAO;

    /**
     * 根据手机号获得用户信息
     * @param mobile 手机号
     * @return
     */
    @Override
    public User queryUserByMobile(String mobile) {
        return userDAO.queryUserByMobile(mobile);
    }

    /**
     * 用户验证码登录
     * @param user 用户
     * @param source 上游渠道
     */
    @Override
    public void saveOrUpdateUser(User user, String source) {
        // 若为新用户
        if(user.getId() == null) {
            if(StringUtils.isBlank(source)) {
                source = "or001";
            }
            Source sourceEntity = sourceDAO.querySourceByName(source);
            user.setSourceId(sourceEntity.getId());
            userDAO.saveUser(user);
        } else {
            // 更新用户uuid
            userDAO.updateUserUUIDById(user.getUuid(),user.getId());
        }
    }

    /**
     * 根据uuid获得用户信息
     * @param uuid uuid
     * @return
     */
    @Override
    public User queryUserByUUID(String uuid) {
        return userDAO.queryUserByUUID(uuid);
    }

    /**
     * 根据主键id获得用户信息
     * @param id 主键id
     * @return
     */
    @Override
    public User queryUserById(Long id) {
        return userDAO.queryUserById(id);
    }
}
