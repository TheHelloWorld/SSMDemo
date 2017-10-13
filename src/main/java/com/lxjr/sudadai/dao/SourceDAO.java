package com.lxjr.sudadai.dao;

import com.lxjr.sudadai.entity.Source;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceDAO {

	/**
	 * 根据上游名称查询上游信息
	 *
	 * @param sourceName 上游名称
	 * @return
	 */
	Source querySourceByName(String sourceName);

	/**
	 * 根据主键Id获得上游
	 *
	 * @param id 主键Id
	 * @return
	 */
	Source querySourceById(Long id);
}
