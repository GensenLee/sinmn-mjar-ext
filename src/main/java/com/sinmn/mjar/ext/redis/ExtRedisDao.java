package com.sinmn.mjar.ext.redis;

import com.sinmn.core.utils.redis.AspectRedisDao;
import com.sinmn.core.utils.redis.annotation.Redis;
import com.sinmn.core.utils.util.StringUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class ExtRedisDao extends AspectRedisDao {

    private String KEY_TEMPLATE_EXT = "EXT_KEY:%s";

    private int expireTime = 60 * 60 * 24;

    @Redis
    public String get(String key, int expireTime) {
        Jedis jedis = getJedis();
        String k = String.format(KEY_TEMPLATE_EXT, key);
        String value = jedis.get(k);
        if (StringUtil.isNotEmpty(value)) {
            //重新设置过期时间
            jedis.setex(key, expireTime, value);
        }
        return value;
    }

    @Redis
    public void set(String key, String value) {
        Jedis jedis = getJedis();
        String k = String.format(KEY_TEMPLATE_EXT, key);
        jedis.setex(k, this.expireTime, value);
    }

    @Redis
    public String get(String key) {
        Jedis jedis = getJedis();
        String k = String.format(KEY_TEMPLATE_EXT, key);
        String value = jedis.get(k);
        if (StringUtil.isNotEmpty(value)) {
            //重新设置过期时间
            jedis.setex(key, this.expireTime, value);
        }
        return value;
    }

    @Redis
    public void set(String key, String value, int expireTime) {
        Jedis jedis = getJedis();
        String k = String.format(KEY_TEMPLATE_EXT, key);
        jedis.setex(k, expireTime, value);
    }

    @Redis
    public void delete(String key){
        Jedis jedis = getJedis();
        String k = String.format(KEY_TEMPLATE_EXT, key);
        jedis.del(k);
    }
}
