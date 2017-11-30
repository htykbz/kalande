package com.business.kalande.entity;

import java.io.Serializable;
import java.util.Date;

public class SinglePages implements Serializable {
    private Integer id;
    private String title;
    private String summary;
    private String imageUrl;
    private String content;
    private Integer singleType;
    private String source;
    private String author;
    private boolean isDeleted;
    private Date createTime;

    public SinglePages() {
    }

    public SinglePages(Integer id, String title, String summary, String imageUrl, String content, Integer singleType, String source, String author, boolean isDeleted, Date createTime) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.content = content;
        this.singleType = singleType;
        this.source = source;
        this.author = author;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSingleType() {
        return singleType;
    }

    public void setSingleType(Integer singleType) {
        this.singleType = singleType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
