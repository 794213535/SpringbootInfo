package com.cskaoyan.project.vo;

import com.cskaoyan.project.bean.News;
import com.cskaoyan.project.bean.User;

public class vo {
    User user;
    News news;
    int like;

    @Override
    public String toString() {
        return "vo{" +
                "user=" + user +
                ", news=" + news +
                ", like=" + like +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public vo() {

    }

    public vo(User user, News news, int like) {

        this.user = user;
        this.news = news;
        this.like = like;
    }
}
