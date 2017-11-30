package com.business.kalande.service.Impl;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.business.kalande.mapper.ProductsMapper;
import com.business.kalande.service.ProductsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsMapper productsMapper;

    public Page<Products> listByPage(PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return productsMapper.listByPage();
    }

    @Override
    public Products findById(Integer id) {
        return productsMapper.findById(id);
    }

    @Override
    public boolean add(Products products) {
        products.setOrderBy(100);
        return productsMapper.add(products);
    }

    @Override
    public boolean update(Products products) {
        return productsMapper.update(products);
    }

    @Override
    public boolean delete(Integer id) {
        return productsMapper.delete(id);
    }

    @Override
    public List<ProductCategoriesVo> getProductCateGories(Integer id) {
        if(id != null) {
            return productsMapper.getProductCateGoriesById(id);
        }else{
            return productsMapper.getProductCateGories();
        }
    }

}
