package com.business.kalande.mapper;

import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "productsMapper")
public interface ProductsMapper {
    /**
     * 产品分页查询
     * @return
     */
    public Page<Products> listByPage();

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
    public List<ProductCategoriesVo> getProductCateGoriesById(Integer id);

    /**
     * 产品分类查询
     * @return
     */
    public List<ProductCategoriesVo> getProductCateGories();


}
