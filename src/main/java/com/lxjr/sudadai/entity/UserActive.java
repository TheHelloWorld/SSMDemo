package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserActive implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/** 主键Id **/
	private Long id;

	/** 用户openId **/
	private String openId;

	/** 用户unionId **/
	private String unionId;

	/** 活动编号 **/
	private String activeCode;

	/** 创建时间 **/
	private Timestamp createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
