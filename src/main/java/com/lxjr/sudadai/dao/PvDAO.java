package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.PV;
import org.springframework.stereotype.Repository;

@Repository
public interface PvDAO {

    /**
     * 储存用户来源
     * @param pv 用户来源
     * @return
     */
    void savePV(PV pv);
}
