package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.Advertisement;

import java.util.List;

public interface IAdvertisementService {

	/**
	 * 获得所有广告
	 *
	 * @return
	 */
	List<Advertisement> queryAllAdvertisement();
}
