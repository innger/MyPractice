package com.ryl.learn.netty4;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by renyulong on 16/2/2.
 */
public class UserInfoVo implements Serializable {

    private Long uid;
    private String email;
    private Double money;
    private Date createTime;

    public UserInfoVo() {
    }

    public UserInfoVo(Long uid, String email, Double money) {
        this.uid = uid;
        this.email = email;
        this.money = money;
        this.createTime = new Date();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", money=" + money +
                ", createTime=" + createTime +
                '}';
    }
}
