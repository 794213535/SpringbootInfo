package com.cskaoyan.project.service.Impl;

import com.cskaoyan.project.bean.Comment;
import com.cskaoyan.project.bean.News;
import com.cskaoyan.project.bean.User;
import com.cskaoyan.project.mapper.NewsDao;
import com.cskaoyan.project.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsDao newsDao;

    @Override
    public List<News> findAllNews() {
        return newsDao.findAllNews();
    }

    @Override
    public User findUserByUsernamefromNews(String username) {
        return newsDao.findUserByUsernamefromNews(username);
    }

    @Override
    public int addNews(News news) {
        return newsDao.addNews(news);
    }

    @Override
    public News findNewsById(String id) {
        return newsDao.findNewsById(id);
    }

    @Override
    public int addComment(Comment comment) {
        return newsDao.addComment(comment);
    }

    @Override
    public int addCommentCount(String newsid) {
        return newsDao.addCommentCount(newsid);
    }

    @Override
    public List<Comment> findCommentByUidAndToid(int id, String newsid) {
        //System.out.println(id+newsid+"dskjfhdsf-=-=-=-=-====================------------------");
        int  newsId = Integer.valueOf(newsid);
        List<Comment> commentByUidAndToid = newsDao.findCommentByUidAndToid(id, newsId);
        //System.out.println(commentByUidAndToid+"-=-=-");
        return commentByUidAndToid;
    }

    @Override
    public int updateLikeCount(int newsid, int likeCount) {
        return newsDao.updateLikeCount(newsid,likeCount);
    }
}
