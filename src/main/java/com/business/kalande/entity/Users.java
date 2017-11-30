package com.business.kalande.entity;

import java.util.Date;

public class Users {
    private Integer userId;
    private String userName;
    private String nickName;
    private String password;
    private boolean isDeleted;
    private Date createTime;

    public Users() {
    }

    public Users(Integer userId, String userName, String nickName, String password, boolean isDeleted, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
