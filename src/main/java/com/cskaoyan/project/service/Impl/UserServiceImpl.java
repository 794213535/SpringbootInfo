package com.cskaoyan.project.service.Impl;


import com.cskaoyan.project.bean.User;
import com.cskaoyan.project.mapper.UserDao;
import com.cskaoyan.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userdao;


    @Override
    public boolean isvalidity(String username) {
        User user = userdao.isValidity(username);

        return user!=null?true:false;
    }

    @Override
    public boolean login(User user) {
        User login = userdao.login(user);
        return login!=null?true:false;
    }

    @Override
    public boolean register(User user) {
        int register = userdao.register(user);
        return register==1?true:false;
    }

    @Override
    public User findNewsByUsername(String username) {
        return userdao.findNewsByUsername(username);
    }

    @Override
    public User findNewsByUserId(int uid) {
        return userdao.findNewsByUserId(uid);
    }

    @Override
    public List<User> findAllUser() {
        return userdao.findAllUser();
    }
}
