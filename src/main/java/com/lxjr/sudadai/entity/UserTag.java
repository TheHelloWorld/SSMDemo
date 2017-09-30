package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserTag implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/** 主键Id **/
	private Long id;

	/** 用户id **/
	private Long userId;

	/** 标签code **/
	private String tagCode;

	/** 选择顺序 **/
	private Integer selectOrder;

	/** 创建时间 **/
	private Timestamp createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public Integer getSelectOrder() {
		return selectOrder;
	}

	public void setSelectOrder(Integer selectOrder) {
		this.selectOrder = selectOrder;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
