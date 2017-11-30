package com.business.kalande.entity;

import java.util.Date;

public class TrainVideos {
    private Integer id;
    private Integer categoryId;
    private String name;
    private String summary;
    private String imageUrl;
    private String vedioUrl;
    private String mp4Url;
    private String coverImageUrl;
    private String content;
    private Double price;
    private Integer viewNum;
    private boolean isRecommend;
    private Integer sortOrder;
    private boolean isDeleted;
    private Date createTime;
    private TrainVideoCategories trainVideoCategories;

    public TrainVideos() {
    }

    public TrainVideos(Integer id, Integer categoryId, String name, String summary, String imageUrl, String vedioUrl, String mp4Url, String coverImageUrl, String content, Double price, Integer viewNum, boolean isRecommend, Integer sortOrder, boolean isDeleted, Date createTime, TrainVideoCategories trainVideoCategories) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.vedioUrl = vedioUrl;
        this.mp4Url = mp4Url;
        this.coverImageUrl = coverImageUrl;
        this.content = content;
        this.price = price;
        this.viewNum = viewNum;
        this.isRecommend = isRecommend;
        this.sortOrder = sortOrder;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.trainVideoCategories = trainVideoCategories;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMp4Url() {
        return mp4Url;
    }

    public void setMp4Url(String mp4Url) {
        this.mp4Url = mp4Url;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public boolean isRecommend() {
        return isRecommend;
    }

    public void setRecommend(boolean recommend) {
        isRecommend = recommend;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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

    public TrainVideoCategories getTrainVideoCategories() {
        return trainVideoCategories;
    }

    public void setTrainVideoCategories(TrainVideoCategories trainVideoCategories) {
        this.trainVideoCategories = trainVideoCategories;
    }
}
