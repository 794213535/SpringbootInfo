package com.cskaoyan.test;

public class JedisService {

    //返回值是点赞的个数
    public int Like (int newsid ,int userid){
        String s = JedisUtils.get("name");
        System.out.println(s+"sdfsad");
        return 0;
    }
}
