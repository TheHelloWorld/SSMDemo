package com.lxjr.sudadai.service;

import com.lxjr.sudadai.entity.Tag;

import java.util.List;

public interface ITagService {

	/**
	 * 获得所有标签
	 *
	 * @return
	 */
	List<Tag> queryAllTag();

	/**
	 * 根据标签code获得数量
	 *
	 * @param tagCode 标签code
	 * @return
	 */
	Integer getCountByTagCode(String tagCode);
}
