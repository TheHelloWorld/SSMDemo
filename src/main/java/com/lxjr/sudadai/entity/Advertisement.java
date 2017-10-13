package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Advertisement implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/**
	 * 主键Id
	 **/
	private Long id;

	/**
	 * 广告名称
	 **/
	private String adName;

	/**
	 * 广告链接
	 **/
	private String adUrl;

	/**
	 * 广告顺序
	 **/
	private Integer adOrder;

	/**
	 * 广告图片URL
	 **/
	private String adImgUrl;

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

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdUrl() {
		return adUrl;
	}

	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}

	public Integer getAdOrder() {
		return adOrder;
	}

	public void setAdOrder(Integer adOrder) {
		this.adOrder = adOrder;
	}

	public String getAdImgUrl() {
		return adImgUrl;
	}

	public void setAdImgUrl(String adImgUrl) {
		this.adImgUrl = adImgUrl;
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
