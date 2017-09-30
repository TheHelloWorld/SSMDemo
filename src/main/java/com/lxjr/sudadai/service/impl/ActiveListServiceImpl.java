package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.dao.ActiveListDAO;
import com.lxjr.sudadai.entity.ActiveInfo;
import com.lxjr.sudadai.service.IActiveListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("activeListService")
public class ActiveListServiceImpl implements IActiveListService {

    @Resource
    private ActiveListDAO activeListDAO;

    /**
     * 根据活动code获得活动信息
     * @param activeCode 活动code
     * @return
     */
    public ActiveInfo queryActiveInfo(String activeCode) {
        return activeListDAO.queryActiveInfoByActiveCode(activeCode);
    }
}
