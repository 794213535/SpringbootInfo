package com.cskaoyan.project.bean;

import java.util.Date;

public class Comment {
    int id;
    Date datetime;
    String text;
    int uid;
    String totype;
    int toid;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", text='" + text + '\'' +
                ", uid=" + uid +
                ", totype='" + totype + '\'' +
                ", toid=" + toid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTotype() {
        return totype;
    }

    public void setTotype(String totype) {
        this.totype = totype;
    }

    public int getToid() {
        return toid;
    }

    public void setToid(int toid) {
        this.toid = toid;
    }

    public Comment() {

    }

    public Comment(int id, Date datetime, String text, int uid, String totype, int toid) {

        this.id = id;
        this.datetime = datetime;
        this.text = text;
        this.uid = uid;
        this.totype = totype;
        this.toid = toid;
    }
}
