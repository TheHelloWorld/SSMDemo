package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.UserTag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTagDAO {

    /**
     * 保存用户标签
     * @param userTag 用户标签
     * @return
     */
    void saveUserTag(UserTag userTag);

    /**
     * 根据用户Id获得用户标签数量
     * @param userId 用户Id
     * @return
     */
    Integer getUserTagsCountByUserId(Long userId);

    /**
     * 根据用户Id获得所有用户标签
     * @param userId 用户Id
     * @return
     */
    List<UserTag> queryUserTagsByUserId(Long userId);
}
