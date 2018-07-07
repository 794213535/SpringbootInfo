package com.cskaoyan.project.Utils;

public class RedisKeyUtil {
    private static String SPLIT = ":";
    private static String BIZ_LIEK = "like";
    private static String BIZ_DISLIKE = "DISLIEK";
    //如果在newsid为2上咨询点赞数后会产生entityID、entitType，增加点赞数
    public static String getLikeKey(int entityID,int entityType){
        return BIZ_LIEK +SPLIT+String.valueOf(entityID)+SPLIT+String.valueOf(entityType);
    }
    //取消赞
    public static String getDisLikeKey(int entityID,int entityType){
        return BIZ_DISLIKE+SPLIT+String.valueOf(entityID)+SPLIT+String.valueOf(entityType);
    }
}
