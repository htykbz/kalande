package com.business.kalande.mapper;

import com.business.kalande.entity.Menu;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "menuMapper")
public interface MenuMapper {
    /**
     * 查询
     * @return
     */
    public List<Menu> listBy();

    /**
     * 查找
     * @param id
     * @return
     */
    public Menu findById(Integer id);

    /**
     * 新增
     * @param menu
     * @return
     */
    public boolean add(Menu menu);

    /**
     * 编辑
     * @param menu
     * @return
     */
    public boolean update(Menu menu);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);



}
