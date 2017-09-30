package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDAO {

    /**
     * 获得所有标签
     * @return
     */
    List<Tag> queryAllTag();

    /**
     * 根据标签code获得数量
     * @param tagCode 标签code
     * @return
     */
    Integer getCountByTagCode(String tagCode);
}
