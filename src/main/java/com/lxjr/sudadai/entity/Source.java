package com.lxjr.sudadai.entity;

import java.io.Serializable;

public class Source implements Serializable{

	
	private static final long serialVersionUID = -4954366162493302680L;
	
	private Long id; 			/*	id bigint 	*/

	private String name; 		/*	来源名称（beta，beta2...）	varchar(100)	*/

	private String sourceCode;	/*	来源码(bt001)	varchar(100)	*/

	private String companyName; 	/*	来源公司名称	varchar（100） */

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

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
		
	
}
