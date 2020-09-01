package com.example.sharding.service;

import com.example.sharding.model.User;

/**
 * Author : Harry
 * Description : UserService
 * Date : 2020-08-28 14:56
 */
public interface UserService {

    void addUser(User user);

    User selectById(int id);
}
