package com.business.kalande.service.Impl;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.TrainVideos;
import com.business.kalande.mapper.TrainVideosMapper;
import com.business.kalande.service.TrainVideosService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainVideosServiceImpl implements TrainVideosService {
    @Autowired
    private TrainVideosMapper trainVideosMapper;
    @Override
    public Page<TrainVideos> listByPage(PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return trainVideosMapper.listByPage();
    }

    @Override
    public TrainVideos findById(Integer id) {
        return trainVideosMapper.findById(id);
    }

    @Override
    public boolean add(TrainVideos trainVideos) {
        return trainVideosMapper.add(trainVideos);
    }

    @Override
    public boolean update(TrainVideos trainVideos) {
        return trainVideosMapper.update(trainVideos);
    }

    @Override
    public boolean delete(Integer id) {
        return trainVideosMapper.delete(id);
    }

    @Override
    public List<ProductCategoriesVo> getTrainVideoGoriesById(Integer id) {
        if(id != null) {
            return trainVideosMapper.getTrainVideoGoriesById(id);
        }else{
            return trainVideosMapper.getTrainVideoCateGories();
        }
    }

}
