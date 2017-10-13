package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.ActiveInfo;

public interface IActiveListService {

	/**
	 * 根据活动code获得活动信息
	 *
	 * @param activeCode 活动code
	 * @return
	 */
	ActiveInfo queryActiveInfo(String activeCode);
}
