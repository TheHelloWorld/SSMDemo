package com.lxjr.sudadai.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lxjr.sudadai.entity.Target;

public class TargetSort {

	/**
	 * 权重
	 **/
	private Integer weight;

	/**
	 * 平台属性json串
	 **/
	private JSONObject jsonObject;

	/**
	 * 平台
	 **/
	private Target target;

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
	}
}
