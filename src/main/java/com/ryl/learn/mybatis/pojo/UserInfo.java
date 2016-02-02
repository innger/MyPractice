package com.ryl.learn.mybatis.pojo;

import java.util.Date;

/**
 * Created by renyulong on 16/1/25.
 */
public class UserInfo {

    private Long uid;
    private String name;
    private Integer age;
    private Date createTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
