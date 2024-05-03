package com.heima.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {

    private static JedisPool jedisPool;

    /**
     * 静态代码块，初始化Jedis连接池
     */
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(1000);

        jedisPool = new JedisPool(poolConfig,"192.168.88.130",6379,1000,"1234");

    }

    /**
     * 获取Jedis连接
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }


}
