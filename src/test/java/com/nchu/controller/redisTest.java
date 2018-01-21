package com.nchu.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by user12 on 2017/12/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTest {

    //简单获取值 保存值
    @Test
    public void testRedis(){
        //设置主机和端口
        Jedis jedis=new Jedis("127.0.0.1",6379);
       //保存数据
        jedis.set("name","xinchen");
        //获取数据
        String value=jedis.get("name");
        System.out.println(value);
        //释放资源
        jedis.close();

    }


    //使用连接池方式
    @Test
    public void testRedisPool(){
        //获取连接池配置对象
        JedisPoolConfig config=new JedisPoolConfig();

        //设置最大连接数
        config.setMaxTotal(30);

        //设置最大的空闲连接数
        config.setMaxIdle(10);

        //获取连接池
        JedisPool jedisPool=new JedisPool(config,"127.0.0.1",6379);

        //获取核心对象
        Jedis jedis=null;

        //通过连接池获取连接
        jedis=jedisPool.getResource();

        //保存数据
        jedis.set("name","xinchen");
        //获取数据
        String value=jedis.get("name");

        System.out.println(value);
        //释放资源
        jedis.close();


    }


}
