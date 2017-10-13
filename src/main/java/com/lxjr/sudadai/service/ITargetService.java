package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.Target;

import java.util.List;

public interface ITargetService {

	/**
	 * 获得默认展示平台list
	 *
	 * @return
	 */
	List<Target> queryDefaultTarget(String source, String sourceUrl);

	/**
	 * 根据用户标签排序目标平台
	 *
	 * @param userId 用户Id
	 * @return
	 */
	List<Target> queryTargetByUserId(Long userId, String source, String sourceUrl);

	/**
	 * 获得所有平台
	 *
	 * @return
	 */
	List<Target> queryAllTarget();

	/**
	 * 根据平台Id获得平台信息
	 *
	 * @param targetId 平台Id
	 * @return
	 */
	Target getTargetById(Long targetId);

}
