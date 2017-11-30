package com.business.kalande.mapper;

import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.TrainVideos;
import com.business.kalande.entity.Trainings;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "trainVideosMapper")
public interface TrainVideosMapper {
     /**
     * 分页查询
     * @return
     */
    public Page<TrainVideos> listByPage();

    /**
     * 查找
     * @param id
     * @return
     */
    public TrainVideos findById(Integer id);

    /**
     * 新增
     * @param trainVideos
     * @return
     */
    public boolean add(TrainVideos trainVideos);

    /**
     * 编辑
     * @param trainVideos
     * @return
     */
    public boolean update(TrainVideos trainVideos);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 视频教学分类查询
     * @return
     */
    public List<ProductCategoriesVo> getTrainVideoGoriesById(Integer id);

    /**
     * 视频教学分类查询
     * @return
     */
    public List<ProductCategoriesVo> getTrainVideoCateGories();


}
