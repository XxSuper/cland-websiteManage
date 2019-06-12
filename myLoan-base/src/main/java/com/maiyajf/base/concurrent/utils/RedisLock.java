package com.maiyajf.base.concurrent.utils;


import java.util.Random;

import com.maiyajf.base.redis.JedisAction;
import com.maiyajf.base.redis.JedisClient;
import com.maiyajf.base.utils.base.BeanUtils;

import redis.clients.jedis.Jedis;


/**
 * RedisLock
 * 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 * @author MYSJPXH
 */
public class RedisLock {

    private JedisClient redisClient;

    private final String lockKey;

    private int expireMsecs = 60 * 1000; // 锁超时，防止线程在入锁以后，无限的执行等待

    private int timeoutMsecs = 10 * 1000; // 锁等待，防止线程饥饿

    /**
     * 锁拥有者标识
     */
    private String owner = BeanUtils.getUUID();

    private boolean locked = false;

    private static Random random = new Random();

    public RedisLock(JedisClient redisClient, String lockKey) {
        this.redisClient = redisClient;
        this.lockKey = lockKey;
    }

    public RedisLock(JedisClient redisClient, String lockKey, int timeoutMsecs) {
        this(redisClient, lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }

    public RedisLock(JedisClient redisClient, String lockKey, int timeoutMsecs, int expireMsecs) {
        this(redisClient, lockKey, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }

    public RedisLock(String lockKey) {
        this(null, lockKey);
    }

    public RedisLock(String lockKey, int timeoutMsecs) {
        this(null, lockKey, timeoutMsecs);
    }

    public RedisLock(String lockKey, int timeoutMsecs, int expireMsecs) {
        this(null, lockKey, timeoutMsecs, expireMsecs);
    }

    /**
     * @return lock key
     */
    public String getLockKey() {
        return lockKey;
    }

    /**
     * 获取锁
     * 
     * @param jedis
     * @return boolean 
     * @throws InterruptedException
     */
    public synchronized boolean acquire() throws InterruptedException {
        return acquire(redisClient);
    }

    /**
     * 获取锁
     * 
     * @param jedis
     * @return boolean
     * @throws InterruptedException
     */
    public synchronized boolean acquire(JedisClient redisClient) throws InterruptedException {
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            if ("OK".equals(redisClient.execute(new JedisAction<String>() {
                @Override
                public String doAction(Jedis jedis) {
                	//设置时间，成功设置返回ok,失败返回null
                    return jedis.set(lockKey, owner, "NX", "PX", expireMsecs);
                }
            }))) {
                locked = true;
                return true;
            }

            int sleepTime = random.nextInt(200);
            timeout -= sleepTime;
            Thread.sleep(sleepTime);
        }
        return false;
    }

    /**
     * 释放
     */
    public synchronized void release() {
        release(redisClient);
    }

    /**
     * 释放
     */
    public synchronized void release(JedisClient redisClient) {
        if (locked && owner.equals(redisClient.execute(new JedisAction<String>() {
            @Override
            public String doAction(Jedis jedis) {
                return jedis.get(lockKey);
            }
        }))) {
            redisClient.execute(new JedisAction<Long>() {
                @Override
                public Long doAction(Jedis jedis) {
                    return jedis.del(lockKey);
                }
            });
            locked = false;
        }
    }

}
