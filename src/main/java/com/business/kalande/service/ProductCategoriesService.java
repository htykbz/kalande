package com.business.kalande.service;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategories;
import com.business.kalande.entity.Products;
import com.github.pagehelper.Page;

public interface ProductCategoriesService {

    public Page<ProductCategories> listByPage(PageInfo page);

    /**
     * 查找
     * @param id
     * @return
     */
    public ProductCategories findById(Integer id);

    /**
     * 新增
     * @param categories
     * @return
     */
    public boolean add(ProductCategories categories);

    /**
     * 编辑
     * @param categories
     * @return
     */
    public boolean update(ProductCategories categories);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);
}
