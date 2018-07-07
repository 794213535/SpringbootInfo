package com.cskaoyan.project.bean;


import java.util.Date;

public class Letter {
    int id ;
    int toid;
    int fromid;
    String content;
    Date sendTime;
    int unread;
    String conversationId;

    @Override
    public String toString() {
        return "Letter{" +
                "id=" + id +
                ", toid=" + toid +
                ", fromid=" + fromid +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", unread=" + unread +
                ", conversationId='" + conversationId + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToid() {
        return toid;
    }

    public void setToid(int toid) {
        this.toid = toid;
    }

    public int getFromid() {
        return fromid;
    }

    public void setFromid(int fromid) {
        this.fromid = fromid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Letter() {

    }

    public Letter(int id, int toid, int fromid, String content, Date sendTime, int unread, String conversationId) {

        this.id = id;
        this.toid = toid;
        this.fromid = fromid;
        this.content = content;
        this.sendTime = sendTime;
        this.unread = unread;
        this.conversationId = conversationId;
    }
}
