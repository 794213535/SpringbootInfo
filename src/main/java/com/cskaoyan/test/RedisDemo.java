package com.cskaoyan.test;

public class RedisDemo {
    public static void main(String[] args) {
        String name = JedisUtils.get("name");
        System.out.println("name="+name);

        String set = JedisUtils.set("name", "sadsafd");

        System.out.println("setname="+set);
    }
}
