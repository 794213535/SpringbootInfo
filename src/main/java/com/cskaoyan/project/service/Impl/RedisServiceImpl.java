package com.cskaoyan.project.service.Impl;

import com.cskaoyan.project.Utils.JedisUtils;
import com.cskaoyan.project.Utils.RedisKeyUtil;
import com.cskaoyan.project.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    JedisUtils jedisUtils;
    //首先判断是点赞还是点踩
    @Override
    public int getLikeStatus(int userid, int entityType, int entityID) {
        String likeKey = RedisKeyUtil.getLikeKey(entityID, entityType);
        //判断是否在集合中
        if(jedisUtils.sismenber(likeKey,String.valueOf(userid))){
            return 1;
        }
        String disLikeKey = RedisKeyUtil.getDisLikeKey(entityID, entityType);
        return jedisUtils.sismenber(disLikeKey,String.valueOf(userid))?-1:0;

    }

    @Override
    public long like(int userid, int entityType, int entityID) {
        //在news上点赞后获取key:LIKE
        String likeKey = RedisKeyUtil.getLikeKey(entityID, entityType);
        jedisUtils.sadd(likeKey,String.valueOf(userid));
        //在喜欢的集合中添加当前操作用户的userid，即被点赞后用户的like集合中就会添加上一个点赞用户的信息
        String disLikeKey = RedisKeyUtil.getDisLikeKey(entityID, entityType);
        jedisUtils.srem(disLikeKey,String.valueOf(userid));


        //返回点赞数量
        return jedisUtils.scard(likeKey);
    }

    @Override
    public long dislike(int userid, int entityType, int entityID) {
        //谁点;击反对，谁就会出现在key为dislike的set集合中
        String disLikeKey = RedisKeyUtil.getDisLikeKey(entityID, entityType);
        jedisUtils.sadd(disLikeKey,String.valueOf(userid));
        //从点赞中删除
        String likeKey = RedisKeyUtil.getLikeKey(entityID, entityType);
        jedisUtils.srem(likeKey,String.valueOf(userid));

        return jedisUtils.scard(likeKey);
    }
}
