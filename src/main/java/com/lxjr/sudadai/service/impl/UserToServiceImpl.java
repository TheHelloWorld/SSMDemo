package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.constants.BaseConstant;
import com.lxjr.sudadai.dao.UserDAO;
import com.lxjr.sudadai.dao.UserToDAO;
import com.lxjr.sudadai.entity.Source;
import com.lxjr.sudadai.entity.Target;
import com.lxjr.sudadai.entity.User;
import com.lxjr.sudadai.entity.UserTo;
import com.lxjr.sudadai.service.IUserToService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userToService")
public class UserToServiceImpl implements IUserToService {

    @Resource
    private UserToDAO userToDAO;

    @Resource
    private UserDAO userDAO;

    /**
     * 更新用户信息并记录用户去向
     * @param target 用户去向平台
     * @param user 用户
     */
    @Override
    public void updateUserAndSaveUserTo(Target target, User user) {
        // 判断用户是否是首次,若是则记录首次去向
        if(user.getFirstTarget() == null ||
                BaseConstant.DEDAULT_FIRST_TARGET.equals(user.getFirstTarget())){
            userDAO.updateUserFirstTargetById(target.getId(),user.getId());
        }
        //先记录用户的去向
        UserTo userTo = new UserTo();
        userTo.setUserId(user.getId());
        userTo.setTargetId(target.getId());
        userTo.setSourceId(user.getSourceId());
        userToDAO.saveUserTo(userTo);
    }

}
