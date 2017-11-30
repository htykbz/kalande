package com.business.kalande.service.Impl;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.News;
import com.business.kalande.mapper.NewsMapper;
import com.business.kalande.service.NewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;


    @Override
    public Page<News> listByPage(PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return newsMapper.listByPage();
    }

    @Override
    public News findById(Integer id) {
        return newsMapper.findById(id);
    }

    @Override
    public boolean add(News news) {
        return newsMapper.add(news);
    }

    @Override
    public boolean update(News news) {
        return newsMapper.update(news);
    }

    @Override
    public boolean delete(Integer id) {
        return newsMapper.delete(id);
    }
}
