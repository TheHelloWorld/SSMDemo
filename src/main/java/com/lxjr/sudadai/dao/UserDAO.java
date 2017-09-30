package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    /**
     * 储存用户信息
     * @param user 用户信息
     * @return
     */
    void saveUser(User user);

    /**
     * 根据主键id修改用户uuid
     * @param uuid 用户uuid
     * @param id 主键id
     */
    void updateUserUUIDById(@Param("uuid") String uuid, @Param("id")Long id);

    /**
     * 根据手机号查询用户信息
     * @param mobile 手机号
     * @return
     */
    User queryUserByMobile(String mobile);

    /**
     * 根据uuid查询用户信息
     * @param uuid uuid
     * @return
     */
    User queryUserByUUID(String uuid);

    /**
     * 根据主键id修改用户第一次目标id
     * @param firstTarget 第一次目标Id
     * @param id 主键Id
     */
    void updateUserFirstTargetById(@Param("firstTarget") Long firstTarget,@Param("id") Long id);

    /**
     * 根据主键Id获得用户信息
     * @param id 主键Id
     * @return
     */
    User queryUserById(Long id);
}
