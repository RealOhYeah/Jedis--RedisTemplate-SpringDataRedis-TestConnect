package com.heima.test;

import com.heima.jedis.utils.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    /**
     * @BeforeEach 每个测试方法执行前执行
     */
    @BeforeEach
    public void setUp(){
        //jedis = new Jedis("192.168.88.130",6379);
        jedis = JedisConnectionFactory.getJedis();
        jedis.auth("1234");
        jedis.select(0);
    }

    /**
     *  @Test 测试方法
     */
    @Test
    public void dummy() {
        String result = jedis.set("name", "小明");
        System.out.println("result=" + result);

        System.out.println(jedis.get("name"));

    }

    /**
     *  @Test 测试方法
     */
    @Test
    public void testHash() {
        jedis.hset("user:1","name", "Jack");
        jedis.hset("user:1","age", "21");
        jedis.hset("user:1","id", "007");


        Map<String,String> map = jedis.hgetAll("user:1");
        System.out.println(map);

    }


    /**
     *  @AfterEach 每个测试方法执行后执行
     *   关闭jedis连接节省资源
     */
    @AfterEach
    public void tearDown(){
        if (jedis!=null){
            jedis.close();
        }
    }

}
