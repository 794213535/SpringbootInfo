package com.cskaoyan.project.service;


import com.cskaoyan.project.bean.User;

import java.util.List;

public interface UserService {
    boolean isvalidity(String username);

    boolean login(User user);

    boolean register(User user);

    User findNewsByUsername(String username);

    User findNewsByUserId(int uid);

    List<User> findAllUser();
}
