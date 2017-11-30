package com.business.kalande.mapper;

import com.business.kalande.entity.News;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "newsMapper")
public interface NewsMapper {
    /**
     * 分页查询
     * @return
     */
    public Page<News> listByPage();

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
