package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public boolean login(User user) {
        String sql = "select * from user where username = ? and password = ?";
        Object[] obj = {user.getUsername(),user.getPassword()};
        boolean flag = false;
        try {
            ResultSet resultSet = this.select(sql, obj);
            while(resultSet.next()){
                    flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int userRegist(User user) {
     String sql = "insert into user(username,password,email)values(?,?,?)";
     Object[] obj = {user.getUsername(),user.getPassword(),user.getEmail()};
        int i = this.setUpdate(sql, obj);
        return i;
    }
}
