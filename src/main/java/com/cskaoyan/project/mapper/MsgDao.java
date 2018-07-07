package com.cskaoyan.project.mapper;


import com.cskaoyan.project.bean.Letter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface MsgDao {

    @Insert("insert into letter values(null,#{toid},#{fromid},#{content},#{sendTime},#{unread},#{conversationId})")
    int sendmsg(Letter letter);


    @Select("select * from letter where toid = #{id} or fromid = #{id}")
    List<Letter> findmsgByUserid(int id);
}
