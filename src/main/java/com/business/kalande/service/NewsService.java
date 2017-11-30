package com.business.kalande.service;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.News;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.github.pagehelper.Page;

import java.util.List;

public interface NewsService {

    public Page<News> listByPage(PageInfo page);

    /**
     * 查找
     * @param id
     * @return
     */
    public News findById(Integer id);

    /**
     * 新增
     * @param news
     * @return
     */
    public boolean add(News news);

    /**
     * 编辑
     * @param news
     * @return
     */
    public boolean update(News news);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);
}
