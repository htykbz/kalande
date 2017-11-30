package com.business.kalande.service;

import com.business.kalande.entity.News;
import com.business.kalande.entity.Users;

public interface UsersService {
    /**
     * 查找
     * @param id
     * @return
     */
    public Users findById(Integer id);
    /**
     * 编辑
     * @param users
     * @return
     */
    public boolean update(Users users);

    /**
     * 查找
     * @param users
     * @return
     */
    public Users exists(Users users);
}
