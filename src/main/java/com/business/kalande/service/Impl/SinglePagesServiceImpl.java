package com.business.kalande.service.Impl;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.Products;
import com.business.kalande.entity.SinglePages;
import com.business.kalande.mapper.ProductsMapper;
import com.business.kalande.mapper.SinglePagesMapper;
import com.business.kalande.service.ProductsService;
import com.business.kalande.service.SinglePagesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinglePagesServiceImpl implements SinglePagesService {
    @Autowired
    private SinglePagesMapper singlePagesMapper;

    public Page<SinglePages> listByPage(PageInfo page, Integer singleType) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return singlePagesMapper.listByPage(singleType);
    }

    @Override
    public SinglePages findById(Integer id) {
        return singlePagesMapper.findById(id);
    }


    @Override
    public boolean update(SinglePages singlePages) {
        return singlePagesMapper.update(singlePages);
    }

    @Override
    public boolean add(SinglePages singlePages) {
        return singlePagesMapper.add(singlePages);
    }

    @Override
    public boolean delete(Integer id) {
        return singlePagesMapper.delete(id);
    }
}
