package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.dao.PvDAO;
import com.lxjr.sudadai.entity.PV;
import com.lxjr.sudadai.service.IPvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("pvService")
public class PvServiceImpl implements IPvService {

    @Resource
    private PvDAO pvDAO;

    /**
     * 储存用户来源
     * @param sourceId 来源Id
     */
    @Override
    public void savePV(Long sourceId) {
        PV pv = new PV();
        pv.setSourceId(sourceId);
        pvDAO.savePV(pv);
    }


}
