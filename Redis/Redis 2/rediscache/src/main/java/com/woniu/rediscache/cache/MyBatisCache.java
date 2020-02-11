package com.woniu.rediscache.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @className:MyBatisCache
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/15 11:47
 * @Version:1.0
 **/
public class MyBatisCache implements Cache {
    private RedisTemplate redisTemplate;
    private String id;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public MyBatisCache(String id){
        if(id==null){
            throw new RuntimeException("缓存失败，请传入id");
        }
        this.id = id;
        System.out.println("this id is "+id);
        redisTemplate = AppliactionContextHolder.get("redisTemplate");
        System.out.println(redisTemplate);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    //缓存准备放数据的方法
    public  void putObject(Object key, Object value) {
        lock.writeLock().lock();
        try {
            redisTemplate.opsForValue().set(key, value, new Random().nextInt(10), TimeUnit.MINUTES);
        }finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    //混窜准备取数据的方法
    public  Object getObject(Object key) {
        Object obj = null;
        lock.readLock().lock();
        try {
            obj = redisTemplate.opsForValue().get(key);
        }finally {
           lock.readLock().unlock();
        }
        return obj;
    }

    @Override
    public Object removeObject(Object key) {
        redisTemplate.opsForValue().set(key, null);
        return null;
    }

    @Override
    public void clear() {
        //以前 你每次调用当前NameSpace下的 insert update delete方法都会引发clear。
        //以前你每次clear 只清空当前namespace下的缓存数据
        //只有你clear 全给你清空了
        //redisTemplate.getConnectionFactory().getConnection().flushDb();
        redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return null;
            }
        });
    }

    @Override
    public int getSize() {
        int size  = (int)redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Long size = connection.dbSize();
                return size;
            }
        });
        return size;
    }
}
