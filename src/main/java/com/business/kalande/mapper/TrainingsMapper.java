package com.business.kalande.mapper;

import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.business.kalande.entity.Trainings;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "trainingsMapper")
public interface TrainingsMapper {
    /**
     * 分页查询
     * @return
     */
    public Page<Trainings> listByPage();

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
     * 图文教学分类查询
     * @return
     */
    public List<ProductCategoriesVo> getTrainGoriesById(Integer id);

    /**
     * 图文教学分类查询
     * @return
     */
    public List<ProductCategoriesVo> getTrainCateGories();


}
