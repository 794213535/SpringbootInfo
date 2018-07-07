package com.cskaoyan.project.vo;

import com.cskaoyan.project.bean.Comment;
import com.cskaoyan.project.bean.News;
import com.cskaoyan.project.bean.User;

public class commentvo {
    User user;
    Comment comment;

    @Override
    public String toString() {
        return "commentvo{" +
                "user=" + user +
                ", comment=" + comment +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public commentvo() {

    }

    public commentvo(User user, Comment comment) {

        this.user = user;
        this.comment = comment;
    }
}
