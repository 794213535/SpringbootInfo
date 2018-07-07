package com.cskaoyan.project.bean;

import java.util.Date;

public class News {
    int id;
    String title;
    String link;
    String commentCount;
    String image;
    int likeCount;
    Date createDate;
    String username;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", image='" + image + '\'' +
                ", likeCount=" + likeCount +
                ", createDate=" + createDate +
                ", username='" + username + '\'' +
                '}';
    }

    public News() {
    }

    public News(int id, String title, String link, String commentCount, String image, int likeCount, Date createDate, String username) {

        this.id = id;
        this.title = title;
        this.link = link;
        this.commentCount = commentCount;
        this.image = image;
        this.likeCount = likeCount;
        this.createDate = createDate;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
