package com.business.kalande.service;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategories;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductsService {

    public Page<Products> listByPage(PageInfo page);

    /**
     * 查找
     * @param id
     * @return
     */
    public Products findById(Integer id);

    /**
     * 新增
     * @param products
     * @return
     */
    public boolean add(Products products);

    /**
     * 编辑
     * @param products
     * @return
     */
    public boolean update(Products products);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 产品分类查询
     * @return
     */
    public List<ProductCategoriesVo> getProductCateGories(Integer id);
}
