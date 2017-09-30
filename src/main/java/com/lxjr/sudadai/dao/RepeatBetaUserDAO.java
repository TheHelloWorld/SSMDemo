package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.RepeatBetaUser;
import org.springframework.stereotype.Repository;

@Repository
public interface RepeatBetaUserDAO {

    /**
     * 储存RepeatBetaUser
     * @param repeatBetaUser RepeatBetaUser类
     * @return
     */
    void saveRepeatBetaUser(RepeatBetaUser repeatBetaUser);
}
