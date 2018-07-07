package com.cskaoyan.project.service;

import com.cskaoyan.project.bean.Comment;
import com.cskaoyan.project.bean.News;
import com.cskaoyan.project.bean.User;

import java.util.List;

public interface NewsService {
    List<News> findAllNews();

    User findUserByUsernamefromNews(String username);

    int addNews(News news);

    News findNewsById(String id);

    int addComment(Comment comment);

    int addCommentCount(String newsid);

    List<Comment> findCommentByUidAndToid(int id, String newsid);
    int updateLikeCount(int newsid,int likeCount);
}
