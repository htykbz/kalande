package com.business.kalande.entity;

import java.util.Date;

public class News {
    private Integer id;
    private String title;
    private String summary;
    private String imageUrl;
    private String content;
    private String source;
    private String author;
    private boolean isTop;
    private boolean isIndex;
    private boolean isDeleted;
    private Date createTime;

    public News() {
    }

    public News(Integer id, String title, String summary, String imageUrl, String content, String source, String author, boolean isTop, boolean isIndex, boolean isDeleted, Date createTime) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.content = content;
        this.source = source;
        this.author = author;
        this.isTop = isTop;
        this.isIndex = isIndex;
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

    public boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(boolean isTop) {
        this.isTop = isTop;
    }

    public boolean getIsIndex() {
        return isIndex;
    }

    public void setIsIndex(boolean isIndex) {
        this.isIndex = isIndex;
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
