package com.example.sharding.service.impl;

import com.example.sharding.mapper.UserMapper;
import com.example.sharding.model.User;
import com.example.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : Harry
 * Description : UserService
 * Date : 2020-08-28 14:57
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
