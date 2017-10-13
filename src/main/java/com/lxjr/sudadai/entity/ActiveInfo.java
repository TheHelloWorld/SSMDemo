package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ActiveInfo implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/**
	 * 主键Id
	 **/
	private Long id;

	/**
	 * 活动编号
	 **/
	private String activeCode;

	/**
	 * 活动名称
	 **/
	private String activeName;

	/**
	 * 活动地址
	 **/
	private String activeUrl;

	/**
	 * 活动内容
	 **/
	private String activeContent;

	/**
	 * 创建时间
	 **/
	private Timestamp createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	public String getActiveUrl() {
		return activeUrl;
	}

	public void setActiveUrl(String activeUrl) {
		this.activeUrl = activeUrl;
	}

	public String getActiveContent() {
		return activeContent;
	}

	public void setActiveContent(String activeContent) {
		this.activeContent = activeContent;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
