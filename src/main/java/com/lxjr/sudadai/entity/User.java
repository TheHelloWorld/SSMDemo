package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/**
	 * id bigint
	 */
	private Long id;

	/**
	 * 电话	varchar(100)
	 */
	private String mobile;

	/**
	 * 密码	varchar(100)
	 */
	private String password;

	/**
	 * 注册时间 timestamp
	 */
	private Timestamp registerTime;

	/**
	 * 注册来源
	 */
	private Long sourceId;

	/**
	 * 用户第一次访问那个产品,默认为-1
	 */
	private Long firstTarget;

	/**
	 * varchar  对外uuid，放在cookie等
	 */
	private String uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getFirstTarget() {
		return firstTarget;
	}

	public void setFirstTarget(Long firstTarget) {
		this.firstTarget = firstTarget;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
