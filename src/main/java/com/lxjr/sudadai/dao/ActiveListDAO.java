package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.ActiveInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveListDAO {

    /**
     * 根据活动code查询活动信息
     * @param activeCode 活动code
     * @return
     */
    ActiveInfo queryActiveInfoByActiveCode(String activeCode);
}
