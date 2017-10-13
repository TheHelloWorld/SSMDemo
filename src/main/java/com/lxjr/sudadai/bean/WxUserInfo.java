package com.lxjr.sudadai.bean;

public class WxUserInfo {

	/**
	 * 用户openid
	 **/
	private String openid;

	/**
	 * 用户昵称
	 **/
	private String nickname;

	/**
	 * 用户unionid
	 **/
	private String unionid;

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
