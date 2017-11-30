package com.business.kalande.service;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.Menu;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.business.kalande.entity.TreeNode;
import com.github.pagehelper.Page;

import java.util.List;

public interface MenuService {

    public List<TreeNode> listBy();

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
