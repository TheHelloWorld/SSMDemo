package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.Advertisement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementDAO {

    /**
     * 获得所有广告
     * @return
     */
    List<Advertisement> queryAllAdvertisement();
}
