package com.business.kalande.entity;

import java.util.Date;

public class Trainings {
    private Integer id;
    private Integer categoryId;
    private String title;
    private String summary;
    private String imageUrl;
    private String vedioUrl;
    private String content;
    private String source;
    private String author;
    private Double price;
    private Integer viewNum;
    private boolean isDeleted;
    private Date createTime;

    public Trainings() {
    }

    public Trainings(Integer id, Integer categoryId, String title, String summary, String imageUrl, String vedioUrl, String content, String source, String author, Double price, Integer viewNum, boolean isDeleted, Date createTime) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.vedioUrl = vedioUrl;
        this.content = content;
        this.source = source;
        this.author = author;
        this.price = price;
        this.viewNum = viewNum;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public String getVedioUrl() {
        return vedioUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
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
