package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean login(User user) {
        UserDao userDao = new UserDaoImpl();
        boolean b = userDao.login(user);
        return b;
    }

    @Override
    public int userRegist(User user) {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.userRegist(user);
        return i;
    }
}
