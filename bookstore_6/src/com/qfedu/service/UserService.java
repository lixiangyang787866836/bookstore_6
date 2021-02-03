package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {
    boolean login(User user);
    int userRegist(User user);
}
