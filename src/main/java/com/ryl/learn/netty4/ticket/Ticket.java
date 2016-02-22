package com.ryl.learn.netty4.ticket;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by renyulong on 16/2/16.
 */
public class Ticket implements Serializable {

    private long id;
    private String name;
    private String src;
    private String dst;
    private Date startTime;

    public Ticket(long id, String name, String src, String dst, Date startTime) {
        this.id = id;
        this.name = name;
        this.src = src;
        this.dst = dst;
        this.startTime = startTime;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "dst='" + dst + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", src='" + src + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
