package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.Target;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TargetDAO {

	/**
	 * 获得所有平台
	 *
	 * @return
	 */
	List<Target> queryAllTarget();

	/**
	 * 根据id获得平台
	 *
	 * @param id 主键Id
	 * @return
	 */
	Target queryTargetById(Long id);
}
