package com.business.kalande.service.Impl;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Trainings;
import com.business.kalande.mapper.TrainingsMapper;
import com.business.kalande.service.TrainingsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainingsServiceImpl implements TrainingsService{
    @Autowired
    private TrainingsMapper trainingsMapper;
    @Override
    public Page<Trainings> listByPage(PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return trainingsMapper.listByPage();
    }

    @Override
    public Trainings findById(Integer id) {
        return trainingsMapper.findById(id);
    }

    @Override
    public boolean add(Trainings trainings) {
        return trainingsMapper.add(trainings);
    }

    @Override
    public boolean update(Trainings trainings) {
        return trainingsMapper.update(trainings);
    }

    @Override
    public boolean delete(Integer id) {
        return trainingsMapper.delete(id);
    }

    @Override
    public List<ProductCategoriesVo> getTrainGories(Integer id) {
        if(id != null) {
            return trainingsMapper.getTrainGoriesById(id);
        }else{
            return trainingsMapper.getTrainCateGories();
        }
    }
}
