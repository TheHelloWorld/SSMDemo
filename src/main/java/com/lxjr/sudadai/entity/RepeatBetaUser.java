package com.lxjr.sudadai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class RepeatBetaUser implements Serializable {

	private static final long serialVersionUID = -4954366162493302680L;

	/**	id **/
	private Long id;

	/**	电话	**/
	private String mobile;

	private Timestamp createTime;

	/**	注册来源 **/
	private Long sourceId;
	
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
