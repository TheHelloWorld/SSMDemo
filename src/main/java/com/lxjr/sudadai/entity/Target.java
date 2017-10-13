package com.lxjr.sudadai.entity;

public class Target {

	/**
	 * id bigint
	 **/
	private Long id;

	/**
	 * 去向名称(i贷，氧气贷款 都属于平安...)
	 **/
	private String name;

	/**
	 * 去向链接 http://www.homecreditcfc.cn/fudai/index
	 * .php?lang=cn&utm_source=Zhidadai&utm_medium=partner&utm_campaign=MCL&utm_content=bt001	varchar(100)
	 **/
	private String url;

	/**
	 * 去向公司名称
	 **/
	private String companyName;

	/**
	 * url类型 1，单个链接，不需要拼接url；2，多个链接需要拼接
	 **/
	private Integer type;

	/**
	 * 点击次数
	 **/
	private Integer clickCount;

	/**
	 * 标签
	 **/
	private String tags;

	/**
	 * 金额区间
	 **/
	private String amountInterval;

	/**
	 * 时间区间
	 **/
	private String timeInterval;

	/**
	 * 申请条件
	 **/
	private String applicationCondition;

	/**
	 * 图片url
	 **/
	private String imgUrl;

	/**
	 * 状态 1:可用 0:不可用
	 **/
	private Integer targetStatus;

	/**
	 * 默认平台顺序
	 **/
	private Integer defaultTargetOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getAmountInterval() {
		return amountInterval;
	}

	public void setAmountInterval(String amountInterval) {
		this.amountInterval = amountInterval;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getApplicationCondition() {
		return applicationCondition;
	}

	public void setApplicationCondition(String applicationCondition) {
		this.applicationCondition = applicationCondition;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(Integer targetStatus) {
		this.targetStatus = targetStatus;
	}

	public Integer getDefaultTargetOrder() {
		return defaultTargetOrder;
	}

	public void setDefaultTargetOrder(Integer defaultTargetOrder) {
		this.defaultTargetOrder = defaultTargetOrder;
	}
}
