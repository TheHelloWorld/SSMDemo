package com.lxjr.sudadai.service;

public interface IUserActiveService {

	/**
	 * 异步查询用户微信信息并储存用户活动记录(因查询微信信息时网络请求, 且只有一个储存操作,所以不开启事务)
	 *
	 * @param code       用户微信code
	 * @param activeCode 活动code
	 */
	void queryWinXinInfoAndSaveUserActive(String code, String activeCode);
}
