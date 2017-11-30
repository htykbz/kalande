package com.business.kalande.mapper;

import com.business.kalande.entity.News;
import com.business.kalande.entity.Users;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "usersMapper")
public interface UsersMapper {
    /**
     * 查找
     * @param id
     * @return
     */
    public Users findById(Integer id);

    /**
     * 查找
     * @param users
     * @return
     */
    public Users exists(Users users);

    /**
     * 编辑
     * @param users
     * @return
     */
    public boolean update(Users users);
}
