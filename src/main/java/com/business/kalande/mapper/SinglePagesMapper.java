package com.business.kalande.mapper;

import com.business.kalande.entity.Products;
import com.business.kalande.entity.SinglePages;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "singlePagesMapper")
public interface SinglePagesMapper {
    /**
     * 品牌文化分页查询
     * @return
     */
    public Page<SinglePages> listByPage(Integer singleType);

    /**
     * 查找
     * @param id
     * @return
     */
    public SinglePages findById(Integer id);


    /**
     * 编辑
     * @param singlePages
     * @return
     */
    public boolean update(SinglePages singlePages);

    /**
     * 新增
     * @param singlePages
     * @return
     */
    public boolean add(SinglePages singlePages);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);




}
