package com.cskaoyan.project.service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
public class RedisUtils {
    static JedisPool pool;
    static {
        pool = new JedisPool();
    }
       public String get(String key){
           Jedis resource = pool.getResource();
           return resource.get(key);
       }
       public void incr(String key){
           Jedis resource = pool.getResource();
           resource.incr(key);
       }
       public void decr(String key){
           Jedis resource = pool.getResource();
           resource.decr(key);
       }
       public void set(String key, String value){
           Jedis resource = pool.getResource();
           resource.set(key,value);
       }
}
