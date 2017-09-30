package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.TargetTag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TargetTagDAO {

    /**
     * 获得所有平台标签
     * @return
     */
    List<TargetTag> queryAllTargetTag();
}
