package com.business.kalande.service;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.business.kalande.entity.Trainings;
import com.github.pagehelper.Page;

import java.util.List;

public interface TrainingsService {

    public Page<Trainings> listByPage(PageInfo page);

    /**
     * 查找
     * @param id
     * @return
     */
    public Trainings findById(Integer id);

    /**
     * 新增
     * @param trainings
     * @return
     */
    public boolean add(Trainings trainings);

    /**
     * 编辑
     * @param trainings
     * @return
     */
    public boolean update(Trainings trainings);
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
    public List<ProductCategoriesVo> getTrainGories(Integer id);
}
