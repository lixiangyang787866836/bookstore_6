package com.qfedu.dao;

import com.qfedu.entity.User;

public interface UserDao {
    boolean login(User user);
    int userRegist(User user);
}
