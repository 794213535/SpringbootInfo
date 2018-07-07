package com.cskaoyan.project.mapper;


import com.cskaoyan.project.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {


    @Select("select * from user where username = #{username}")
    User isValidity(String username);

    @Insert("insert into user values(null,#{username},#{password})")
    int register(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    User login(User user);

    @Select("select * from user where username = #{username}")
    User findNewsByUsername(String username);

    @Select("select * from user where id = #{uid}")
    User findNewsByUserId(int uid);

    @Select("select * from user")
    List<User> findAllUser();
}
