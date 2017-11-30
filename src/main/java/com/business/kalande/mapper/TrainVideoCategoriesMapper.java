package com.business.kalande.mapper;

import com.business.kalande.entity.TrainVideoCategories;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "trainVideoCategoriesMapper")
public interface TrainVideoCategoriesMapper {
    /**
     * 查找
     * @param id
     * @return
     */
    TrainVideoCategories findById(Integer id);
}
