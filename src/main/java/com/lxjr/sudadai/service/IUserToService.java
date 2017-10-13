package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.Target;
import com.lxjr.sudadai.entity.User;

public interface IUserToService {

	/**
	 * 更新用户信息并记录用户去向
	 *
	 * @param target 用户去向平台
	 * @param user   用户
	 */
	void updateUserAndSaveUserTo(Target target, User user);

}
