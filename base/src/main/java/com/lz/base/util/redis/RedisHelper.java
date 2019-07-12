package com.lz.base.util.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 *  redis工具类
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
@Component
public class RedisHelper {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 从缓存中取对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getObject(String key) {
        //获取key
        byte[] keyBytes = getKey(key);
        byte[] result = null;
        RedisConnection redisConnection = getConnection();
        if(null!=redisConnection){
            try {
                result = redisConnection.get(keyBytes);
            }finally {
                releaseConnection(redisConnection);
            }
        }
        return null!=redisConnection ? (T) redisTemplate.getValueSerializer().deserialize(result) : null;
    }

    /**
     * 更新缓存中的对象，也可以在redis缓存中存入新的对象
     * @param key
     * @param t
     * @param <T>
     */
    public <T> void set(String key, T t) {
        byte[] keyBytes = getKey(key);
        RedisSerializer serializer = redisTemplate.getValueSerializer();
        byte[] val = serializer.serialize(t);
        RedisConnection redisConnection = getConnection();
        if(null!=redisConnection){
            try {
                redisConnection.set(keyBytes, val);
            }finally {
                releaseConnection(redisConnection);
            }
        }
    }

    /**
     * 更新缓存中的对象，也可以在redis缓存中存入新的对象 设置过期时间
     * @param key
     * @param t
     * @param time
     * @param <T>
     */
    public <T> void set(String key, T t,long time) {
        byte[] keyBytes = getKey(key);
        RedisSerializer serializer = redisTemplate.getValueSerializer();
        byte[] val = serializer.serialize(t);
        RedisConnection redisConnection = getConnection();

        if(null!=redisConnection){
            try {
                redisConnection.set(keyBytes, val);
                redisConnection.expire(keyBytes, time);
            }finally {
                releaseConnection(redisConnection);
            }
        }
    }

    /**
     * 删除指定对象
     * @param key
     * @return
     */
    public long del(String key){
        RedisConnection redisConnection = getConnection();
        long rlt = 0L;
        if(null!=redisConnection){
            try {
                rlt = redisConnection.del(getKey(key));
            }finally {
                releaseConnection(redisConnection);
            }
        }
        return rlt;
    }



    /**
     * 获取缓存的key
     * @param id
     * @return
     */
    private <T> byte[] getKey(T id) {
        RedisSerializer serializer = redisTemplate.getKeySerializer();
        return serializer.serialize(id);
    }

    /**
     * 获取连接
     * @return
     */
    private RedisConnection getConnection() {
        return Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
    }

    /**
     * 释放连接
     * @param redisConnection
     */
    private void releaseConnection(RedisConnection redisConnection){
        if(null!=redisConnection && null!=redisTemplate){
            RedisConnectionFactory redisConnectionFactory = redisTemplate.getConnectionFactory();

            if(null!=redisConnectionFactory){
                RedisConnectionUtils.releaseConnection(redisConnection, redisConnectionFactory);
            }
        }
    }

}
