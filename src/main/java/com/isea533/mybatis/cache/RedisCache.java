//package com.isea533.mybatis.cache;
//
//import com.isea533.mybatis.cfg.SpringContextHolder;
//import org.apache.ibatis.cache.Cache;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.stereotype.Component;
//
//import java.nio.charset.Charset;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//@Component("redisCache")
//public class RedisCache implements Cache {
//
//    private String id = "111111111111111111";
//
//    private ReadWriteLock lock = new ReentrantReadWriteLock();
//
//    private GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
//
//    public RedisCache(String id) {
////        this.redisTemplate = SpringContextHolder.getBean(RedisTemplate.class);
//        this.id = id;
//    }
//
//    public RedisTemplate<String, String> getRedisTemplate() {
//        if (this.redisTemplate == null) {
//            this.redisTemplate = SpringContextHolder.getBean(RedisTemplate.class);
//        }
//        return this.redisTemplate;
//    }
//
//    public RedisCache(){}
//
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Override
//    public String getId() {
//        return id;
//    }
//
//    @Override
//    public void putObject(Object key, Object value) {
//        getRedisTemplate().boundHashOps(id).put(key.toString(), new String(serializer.serialize(value)));
//    }
//
//    @Override
//    public Object getObject(Object key) {
//        if (this.getRedisTemplate().hasKey(key.toString())) {
//            String cacheResult = this.getRedisTemplate().boundValueOps(key.toString()).get();
//            return serializer.deserialize(cacheResult.getBytes(Charset.forName("utf-8")));
//        }
//        return null;
//
//    }
//
//    @Override
//    public Object removeObject(Object key) {
//        return this.getRedisTemplate().execute(new RedisCallback<Object>() {
//            @Override
//            public Object doInRedis(RedisConnection connection) throws DataAccessException {
//                return connection.del(key.toString().getBytes(Charset.forName("utf-8")));
//            }
//        });
//    }
//
//    @Override
//    public void clear() {
//        this.getRedisTemplate().execute(new RedisCallback<Object>() {
//            @Override
//            public Object doInRedis(RedisConnection connection) throws DataAccessException {
//                connection.flushDb();
//                return null;
//            }
//        });
//    }
//
//    @Override
//    public int getSize() {
//        return this.getRedisTemplate().execute(new RedisCallback<Integer>() {
//            @Override
//            public Integer doInRedis(RedisConnection connection) throws DataAccessException {
//                return Long.valueOf(connection.dbSize()).intValue();
//            }
//        });
//    }
//
//    @Override
//    public ReadWriteLock getReadWriteLock() {
//        return lock;
//    }
//}
