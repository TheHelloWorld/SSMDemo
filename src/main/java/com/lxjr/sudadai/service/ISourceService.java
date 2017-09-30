package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.Source;

public interface ISourceService {

    /**
     * 根据上游名称查询上游信息
     * @param sourceName 上游名称
     * @return
     */
    Source querySourceByName(String sourceName);

    /**
     * 根据主键Id获得上游
     * @param id 主键Id
     * @return
     */
    Source querySourceById(Long id);
}
