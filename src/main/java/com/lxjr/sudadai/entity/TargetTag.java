package com.lxjr.sudadai.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;
import java.sql.Timestamp;

public class TargetTag implements Serializable {

    private static final long serialVersionUID = -4954366162493302680L;

    /** 主键Id **/
    private Long id;

    /** 平台Id **/
    private Long targetId;

    /** 标签Code **/
    private String tagCode;

    /** 标签中文 **/
    private String tagContext;

    /** 创建时间 **/
    private Timestamp createTime;

    /** 更新时间 **/
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagContext() {
        return tagContext;
    }

    public void setTagContext(String tagContext) {
        this.tagContext = tagContext;
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

    @Override
    public String toString(){
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
    }
}
