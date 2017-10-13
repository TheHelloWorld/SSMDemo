package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/**
	 * 主键Id
	 **/
	private Long id;

	/**
	 * 用户id
	 **/
	private Long userId;

	/**
	 * 真实姓名
	 **/
	private String realName;

	/**
	 * 身份证号
	 **/
	private String idCardNo;

	/**
	 * 创建时间
	 **/
	private Timestamp createTime;

	/**
	 * 更新时间
	 **/
	private Timestamp updateTime;

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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
