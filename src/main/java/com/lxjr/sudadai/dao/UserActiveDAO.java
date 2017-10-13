package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.UserActive;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActiveDAO {

	/**
	 * 储存用户活动
	 *
	 * @param userActive 用户活动类
	 */
	void saveUserActive(UserActive userActive);

}
