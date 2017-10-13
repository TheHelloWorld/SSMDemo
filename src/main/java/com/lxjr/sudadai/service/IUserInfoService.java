package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.UserInfo;
import com.lxjr.sudadai.entity.UserTag;

import java.util.List;

public interface IUserInfoService {

	/**
	 * 根据用户Id获得用户信息数量
	 *
	 * @param userId 用户Id
	 * @return
	 */
	Integer getUserInfoCount(Long userId);

	/**
	 * 储存用户信息及标签
	 *
	 * @param userInfo    用户信息
	 * @param userTagList 用户标签
	 */
	String saveUserInfoAndTags(UserInfo userInfo, List<UserTag> userTagList);
}
