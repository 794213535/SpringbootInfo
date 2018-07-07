package com.cskaoyan.project.service;



public interface RedisService {
    int getLikeStatus(int userid,int entityType,int entityID);
    long like(int userid,int entityType,int entityID);
    long dislike(int userid,int entityType,int entityID);
}
