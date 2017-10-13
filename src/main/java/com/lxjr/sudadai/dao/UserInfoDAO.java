package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDAO {

	/**
	 * 根据用户Id获得用户信息数量
	 *
	 * @param userId 用户id
	 * @return
	 */
	Integer getUserInfoCount(Long userId);

	/**
	 * 保存用户信息
	 *
	 * @param userInfo 用户信息
	 * @return
	 */
	void saveUserInfo(UserInfo userInfo);

	/**
	 * 根据身份证号和用户Id获得用户信息数量
	 *
	 * @param idCardNo 身份证号
	 * @param userId   用户Id
	 * @return
	 */
	Integer getUserInfoCountByIdCardNoAndUserId(@Param("idCardNo") String idCardNo, @Param("userId") Long userId);
}
