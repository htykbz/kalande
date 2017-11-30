package com.business.kalande.entity;

import java.io.Serializable;
import java.util.Date;

public class Products implements Serializable {
    private Integer id;
    private Integer categoryId;
    private String title;
    private String summary;
    private String imageUrl;
    private String vedioUrl;
    private String taoBaoUrl;
    private String taoBaoQrcodeImageUrl;
    private String wechatQrcodeImageUrl;
    private Double price;
    private Integer orderBy;
    private Integer saleNum;
    private String content;
    private boolean isDeleted;
    private Date createTime;

    public Products() {
    }

    public Products(Integer id, Integer categoryId, String title, String summary, String imageUrl, String vedioUrl, String taoBaoUrl, String taoBaoQrcodeImageUrl, String wechatQrcodeImageUrl, Double price, Integer orderBy, Integer saleNum, String content, boolean isDeleted, Date createTime) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.vedioUrl = vedioUrl;
        this.taoBaoUrl = taoBaoUrl;
        this.taoBaoQrcodeImageUrl = taoBaoQrcodeImageUrl;
        this.wechatQrcodeImageUrl = wechatQrcodeImageUrl;
        this.price = price;
        this.orderBy = orderBy;
        this.saleNum = saleNum;
        this.content = content;
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

    public String getTaoBaoUrl() {
        return taoBaoUrl;
    }

    public void setTaoBaoUrl(String taoBaoUrl) {
        this.taoBaoUrl = taoBaoUrl;
    }

    public String getTaoBaoQrcodeImageUrl() {
        return taoBaoQrcodeImageUrl;
    }

    public void setTaoBaoQrcodeImageUrl(String taoBaoQrcodeImageUrl) {
        this.taoBaoQrcodeImageUrl = taoBaoQrcodeImageUrl;
    }

    public String getWechatQrcodeImageUrl() {
        return wechatQrcodeImageUrl;
    }

    public void setWechatQrcodeImageUrl(String wechatQrcodeImageUrl) {
        this.wechatQrcodeImageUrl = wechatQrcodeImageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
