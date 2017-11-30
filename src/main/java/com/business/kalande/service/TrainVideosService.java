package com.business.kalande.service;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.TrainVideos;
import com.github.pagehelper.Page;

import java.util.List;

public interface TrainVideosService {
    /**
     * 分页查询
     * @return
     */
    public Page<TrainVideos> listByPage(PageInfo page);
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

}
