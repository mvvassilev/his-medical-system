package com.neuedu.hismedicalsystem.model.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolUtil {
    private static JedisPool pool;
    static {
        String host = "192.168.37.142";
        int port = 6379;
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        pool = new JedisPool(poolConfig, host, port);

    }

    public static Jedis getJedis(){
        Jedis jedis = pool.getResource();
        jedis.auth("123");
        return jedis;
    }

    public static void close(Jedis jedis) {
        jedis.close();
    }
}
