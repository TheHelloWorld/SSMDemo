package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.User;

public interface IUserService {

	/**
	 * 根据手机号获得用户信息
	 *
	 * @param mobile 手机号
	 * @return
	 */
	User queryUserByMobile(String mobile);

	/**
	 * 用户验证码登录
	 *
	 * @param user   用户
	 * @param source 上游渠道
	 */
	void saveOrUpdateUser(User user, String source);

	/**
	 * 根据uuid获得用户信息
	 *
	 * @param uuid uuid
	 * @return
	 */
	User queryUserByUUID(String uuid);

	/**
	 * 根据主键id获得用户信息
	 *
	 * @param id 主键id
	 * @return
	 */
	User queryUserById(Long id);

}
