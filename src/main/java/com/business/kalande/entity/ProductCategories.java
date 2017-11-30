package com.business.kalande.entity;

import java.util.Date;

public class ProductCategories {
    private Integer id;
    private Integer categoryEnum;
    private String name;
    private String imageUrl;
    private boolean showIndex;
    private Integer orderBy;
    private boolean isDeleted;
    private Date createTime;

    public ProductCategories() {
    }

    public ProductCategories(Integer id, Integer categoryEnum, String name, String imageUrl, boolean showIndex, Integer orderBy, boolean isDeleted, Date createTime) {
        this.id = id;
        this.categoryEnum = categoryEnum;
        this.name = name;
        this.imageUrl = imageUrl;
        this.showIndex = showIndex;
        this.orderBy = orderBy;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(Integer categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isShowIndex() {
        return showIndex;
    }

    public void setShowIndex(boolean showIndex) {
        this.showIndex = showIndex;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
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
