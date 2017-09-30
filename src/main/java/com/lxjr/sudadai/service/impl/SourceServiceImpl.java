package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.dao.SourceDAO;
import com.lxjr.sudadai.entity.Source;
import com.lxjr.sudadai.service.ISourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("sourceService")
public class SourceServiceImpl implements ISourceService {

    @Resource
    private SourceDAO sourceDAO;

    /**
     * 根据上游名称查询上游信息
     * @param sourceName 上游名称
     * @return
     */
    @Override
    public Source querySourceByName(String sourceName) {
        return sourceDAO.querySourceByName(sourceName);
    }

    /**
     * 根据主键Id获得上游
     * @param id 主键Id
     * @return
     */
    @Override
    public Source querySourceById(Long id) {
        return sourceDAO.querySourceById(id);
    }
}
