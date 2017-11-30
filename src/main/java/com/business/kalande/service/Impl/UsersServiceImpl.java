package com.business.kalande.service.Impl;

import com.business.kalande.entity.News;
import com.business.kalande.entity.Users;
import com.business.kalande.mapper.UsersMapper;
import com.business.kalande.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users findById(Integer id) {
        return usersMapper.findById(id);
    }

    @Override
    public boolean update(Users users) {
        return usersMapper.update(users);
    }

    @Override
    public Users exists(Users users) {
        return usersMapper.exists(users);
    }
}
