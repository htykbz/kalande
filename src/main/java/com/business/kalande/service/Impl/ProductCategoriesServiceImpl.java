package com.business.kalande.service.Impl;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategories;
import com.business.kalande.entity.Products;
import com.business.kalande.mapper.ProductCategoriesMapper;
import com.business.kalande.mapper.ProductsMapper;
import com.business.kalande.service.ProductCategoriesService;
import com.business.kalande.service.ProductsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService {
    @Autowired
    private ProductCategoriesMapper categoriesMapper;

    public Page<ProductCategories> listByPage(PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return categoriesMapper.listByPage();
    }

    @Override
    public ProductCategories findById(Integer id) {
        return categoriesMapper.findById(id);
    }

    @Override
    public boolean add(ProductCategories categories) {
        return categoriesMapper.add(categories);
    }

    @Override
    public boolean update(ProductCategories categories) {
        return categoriesMapper.update(categories);
    }

    @Override
    public boolean delete(Integer id) {
        return categoriesMapper.delete(id);
    }
}
