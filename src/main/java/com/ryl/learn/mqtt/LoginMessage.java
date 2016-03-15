package com.ryl.learn.mqtt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by renyulong on 16/2/24.
 */
public class LoginMessage implements Serializable {

    private Long messageId;
    private String userId;
    private String token;
    private Date date;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "messageId=" + messageId +
                ", userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                ", date=" + DateFormatUtils.format(date,"yyyy-MM-dd HH:mm:ss") +
                '}';
    }

    public byte[] writeToByteArr() {
        String str = JSON.toJSONString(this);
        return str.getBytes(CharsetUtil.UTF_8);
//        return JSON.toJSONBytes(this);
    }

    public void readFromByteArr(byte[] arr) {
//        JSONObject obj = (JSONObject) JSON.parse(arr);
        String str = new String(arr, CharsetUtil.UTF_8);
        LoginMessage login = JSON.parseObject(str, LoginMessage.class);
        this.setMessageId(login.getMessageId());
        this.setToken(login.getToken());
        this.setUserId(login.getUserId());
        this.setDate(login.getDate());
    }

}
