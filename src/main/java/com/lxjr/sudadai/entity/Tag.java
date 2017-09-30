package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Tag implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/** 主键Id **/
	private Long id;

	/** 标签Code **/
	private String tagCode;

	/** 描述 **/
	private String content;

	/** 创建时间 **/
	private Timestamp createTime;

	/** 习惯时间 **/
	private Timestamp updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
