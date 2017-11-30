package com.business.kalande.entity;

import java.util.Date;

public class Menu {
    private int pid;
    private int id;
    private String title;
    private String url;
    private String summary;
    private int orderBy;
    private boolean isDeleted;
    private Date createTime;

    public Menu() {
    }

    public Menu(int pid, int id, String title, String url, String summary, int orderBy, boolean isDeleted, Date createTime) {
        this.pid = pid;
        this.id = id;
        this.title = title;
        this.url = url;
        this.summary = summary;
        this.orderBy = orderBy;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
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
