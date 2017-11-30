package com.business.kalande.mapper;

import com.business.kalande.entity.ProductCategories;
import com.business.kalande.entity.Products;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "categoriesMapper")
public interface ProductCategoriesMapper {
    /**
     * 产品分类分页查询
     * @return
     */
    public Page<ProductCategories> listByPage();

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
