package com.maiyajf.base.concurrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maiyajf.base.concurrent.utils.RedisLock;
import com.maiyajf.base.redis.JedisAction;
import com.maiyajf.base.redis.JedisClient;
import com.maiyajf.base.utils.log.ExceptionLogger;

import redis.clients.jedis.Jedis;

@Component
public class LockServiceImpl implements LockService {

	@Autowired
    JedisClient jedisClient;
	
    /**
     * 默认排队时间长度，10秒
     */
    private static final int DEFAULT_TIME_OUT_MSECS = 10 * 1000;

    /**
     * 默认锁时间长度，600秒
     */
    private static final int DEFAULT_EXPIRE_MSECS = 600 * 1000;
	
    
	@Override
	public boolean lock(String lockKey) {
		 RedisLock jedisLock = new RedisLock(jedisClient, lockKey, DEFAULT_TIME_OUT_MSECS, DEFAULT_EXPIRE_MSECS);		
		 try {
			return jedisLock.acquire();
		} catch (InterruptedException e) {
			return false;
		}
	}
	
	@Override
	public boolean lockNoWait(String lockKey, int expireMsecs) {
		 RedisLock jedisLock = new RedisLock(jedisClient, lockKey, 0,expireMsecs );		
		 try {
			return jedisLock.acquire();
		} catch (InterruptedException e) {
			return false;
		}
	}
	
	@Override
	public boolean lock(String lockKey, int timeoutMsecs, int expireMsecs) {
		 RedisLock jedisLock = new RedisLock(jedisClient, lockKey, timeoutMsecs, expireMsecs);		
		 try {
			return jedisLock.acquire();
		} catch (InterruptedException e) {
			return false;
		}
	}

	@Override
	public void unLock(final String lockKey) {
		try {
			jedisClient.execute(new JedisAction<Long>() {
				@Override
				public Long doAction(Jedis jedis) {
					return jedis.del(lockKey);
				}
			});
		} catch (Exception e) {
			ExceptionLogger.error("释放redis异常---", "", e);
		}
	}

}
