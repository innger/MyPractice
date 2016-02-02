package com.ryl.learn.netty4;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by renyulong on 16/1/28.
 */
public class MessageVo implements Serializable {

    private Integer id;
    private String name;
    private String content;
    private Date createTime;

    public MessageVo() {
    }

    public MessageVo(Integer id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createTime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
