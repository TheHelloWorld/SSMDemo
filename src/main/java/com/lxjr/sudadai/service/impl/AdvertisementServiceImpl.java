package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.dao.AdvertisementDAO;
import com.lxjr.sudadai.entity.Advertisement;
import com.lxjr.sudadai.service.IAdvertisementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("advertisementService")
public class AdvertisementServiceImpl implements IAdvertisementService {

    @Resource
    private AdvertisementDAO advertisementDAO;

    /**
     * 获得所有广告
     * @return
     */
    @Override
    public List<Advertisement> queryAllAdvertisement() {
        return advertisementDAO.queryAllAdvertisement();
    }
}
