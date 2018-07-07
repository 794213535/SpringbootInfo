package com.cskaoyan.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class JedisUtils  {


    static JedisPool pool;
    static {

        pool = new JedisPool();

    }


    public static String get(String key){


        String v=null;
        Jedis jedis=null;
        try {
            jedis = pool.getResource();

            v = jedis.get(key);
        }catch (Exception e){

            System.out.println("e"+e.getCause());

        }
        finally {

            if (jedis!=null){
                jedis.close();
            }

        }



        return  v;
    }

    public static String set(String key,String value){

        Jedis jedis=null;
        String set=null;
        try {
            jedis = pool.getResource();

              set = jedis.set(key, value);
        }catch (Exception e){

            System.out.println("e"+e.getCause());

        }
        finally {

            if (jedis!=null){
                jedis.close();
            }

        }


        return  set;
    }

    //增加点赞效果
    public static Long sadd(String key, String value){
        Jedis jedis = null;
        Long sadd = null;
        try {
            jedis = pool.getResource();
            sadd = jedis.sadd(key, value);

        }catch (Exception e){
            System.out.println("e"+e.getCause());

        }finally {
            if (jedis!=null){
                jedis.close();

            }
        }
        return sadd;
    }
    //移除点赞效果
    public static Long srem(String key,String value){
        Jedis jedis = pool.getResource();
        Long srem = jedis.srem(key, value);
        return srem;
    }
    //判断key value中是否有集合中的值
    public static boolean sismenber(String key,String value){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return jedis.sismember(key, value);
        }catch (Exception e){
            System.out.println("jedis sismenber"+e.getCause());
            return false;
        }finally {
            if (jedis!=null){
                try{
                    jedis.close();
                }catch (Exception e){
                    System.out.println("jedis 关闭异常"+e.getCause());
                }
            }

        }
    }
    //判断集合的大小
    public static long scard(String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.scard(key);
        }catch (Exception e){
            System.out.println("jedis scard"+e.getCause());
            return 0;
        }finally {
            if (jedis!=null){
                try{
                    jedis.close();
                }catch (Exception e){
                    System.out.println("jedis 关闭异常"+e.getCause());
                }
            }
        }
    }

}
