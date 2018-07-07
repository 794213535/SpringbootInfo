package com.cskaoyan.project.mapper;


import com.cskaoyan.project.bean.Comment;
import com.cskaoyan.project.bean.News;
import com.cskaoyan.project.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface NewsDao {
    @Select("select * from news order by id DESC")
    List<News> findAllNews();

    @Select("select * from user where username = #{username}")
    User findUserByUsernamefromNews(String username);

    @Insert("insert into news values(null,#{title},#{link},#{image},0,#{createDate},#{username},0)")
    int addNews(News news);

    @Select("select * from news where id = #{id}")
    News findNewsById(String id);

    @Insert("insert into comment values(null,#{datetime},#{text},#{uid},#{totype},#{toid})")
    int addComment(Comment comment);

    @Update("update news set commentCount = commentCount + 1 where id =#{id}")
    int addCommentCount(String newsid);

    @Select("select * from comment where toid = #{newsId} order by id desc")
    List<Comment> findCommentByUidAndToid(@Param("id")int id,@Param("newsId") int newsId);

    @Update("update news set likeCount = #{likecount} where id = #{newsid}")
    int updateLikeCount(int newsid, int likecount);
}
