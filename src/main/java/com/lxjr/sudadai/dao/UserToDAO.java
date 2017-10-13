package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.UserTo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToDAO {

	/**
	 * 保存用户去向
	 *
	 * @param userTo 用户去向
	 * @return
	 */
	void saveUserTo(UserTo userTo);
}
