package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserTo implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/**
	 * id bigint
	 */
	private Long id;

	/**
	 * 用户id	bigint
	 */
	private Long userId;

	/**
	 * 来源id 	bigint
	 */
	private Long sourceId;

	/**
	 * 去向id	bigint
	 */
	private Long targetId;

	/**
	 * 时间	timestamp
	 */
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

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

}
