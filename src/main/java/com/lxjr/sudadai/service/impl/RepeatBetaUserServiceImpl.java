package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.dao.RepeatBetaUserDAO;
import com.lxjr.sudadai.entity.RepeatBetaUser;
import com.lxjr.sudadai.service.IRepeatBetaUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("repeatBetaUserService")
public class RepeatBetaUserServiceImpl implements IRepeatBetaUserService {

	@Resource
	private RepeatBetaUserDAO repeatBetaUserDAO;

	/**
	 * 保存RepeatBetaUser
	 *
	 * @param repeatBetaUser RepeatBetaUser类
	 * @return
	 */
	@Override
	public void saveRepeatBetaUser(RepeatBetaUser repeatBetaUser) {
		repeatBetaUserDAO.saveRepeatBetaUser(repeatBetaUser);
	}

}
