package cn.yygcloud.ssmdemo.common.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisUtils
 * @Description:
 * @author: Nan
 * @date: 2020/10/7 21:58
 * @version: V1.0
 */

public class RedisUtils {
    private RedisTemplate<Serializable, Object> redisTemplate;
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key(模糊查询)
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0){
            redisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /*
    *@Author : Nan
    *@Description : 获取剩余过期时间
    *@Date : 15:42 2020/10/8
    *@Param : [k]
    *@return : long
    *@Desc :
    */
    public  long getExpire(String k){
        Long time=0L;
        time=redisTemplate.getExpire(k);
        return time;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
    *@Author : Nan
    *@Description :  简单类型的写入
    *@Date : 15:00 2020/10/8
    *@Param : [key, value]
    *@return : boolean
    *@Desc :
    */
    public  boolean simpleSet(final String key,String value){
        boolean result=false;
        try {
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            stringStringValueOperations.set(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    /*
    *@Author : Nan
    *@Description : 简单类型的写入,带过期时间
    *@Date : 15:05 2020/10/8
    *@Param : [key, value, expireTime]
    *@return : boolean
    *@Desc :
    */
    public  boolean simpleSet(final String key,String value,long expireTime){
        boolean result=false;
        result= simpleSet(key, value);
        if(result){
            stringRedisTemplate.expire(key,expireTime,TimeUnit.SECONDS);
        }
        return result;
    }

    public  String simpleGet(String k){
        String result=null;
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        result = stringStringValueOperations.get(k);
        return result;
    }



    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
