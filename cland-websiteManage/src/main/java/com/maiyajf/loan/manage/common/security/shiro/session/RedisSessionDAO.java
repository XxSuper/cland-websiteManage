package com.maiyajf.loan.manage.common.security.shiro.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.security.shiro.SerializeUtils;
import com.maiyajf.loan.manage.common.security.shiro.cache.redis.RedisManager;

/**
 * @ClassName: RedisSessionDAO
 * @Description: redis sessiondao
 * @author: zhuangsheng.chen
 * @date: 2016年2月23日 上午10:24:02
 */
public class RedisSessionDAO extends AbstractSessionDAO {


  /**
   * shiro-redis的session对象前缀
   */
  private RedisManager redisManager;

  /**
   * The Redis key prefix for the sessions
   */
  private String keyPrefix = "shiro_redis_session:";

  @Override
  public void update(Session session) throws UnknownSessionException {
    this.saveSession(session);
  }

  /**
   * save session
   * 
   * @param session
   * @throws UnknownSessionException
   */
  private void saveSession(Session session) throws UnknownSessionException {
    if (session == null || session.getId() == null) {
      ExceptionLogger.error("myloan-manager", "session or session id is null");
      return;
    }

    byte[] key = getByteKey(session.getId());
    byte[] value = SerializeUtils.serialize(session);
    session.setTimeout(redisManager.getExpire() * 1000);
    this.redisManager.set(key, value, redisManager.getExpire());
  }

  @Override
  public void delete(Session session) {
    if (session == null || session.getId() == null) {
      ExceptionLogger.error("myloan-manager", "session or session id is null");
      return;
    }
    redisManager.del(this.getByteKey(session.getId()));

  }

  @Override
  public Collection<Session> getActiveSessions() {
    Set<Session> sessions = new HashSet<Session>();

    Set<byte[]> keys = redisManager.keys(this.keyPrefix + "*");
    if (keys != null && keys.size() > 0) {
      for (byte[] key : keys) {
        Session s = (Session) SerializeUtils.deserialize(redisManager.get(key));
        sessions.add(s);
      }
    }

    return sessions;
  }

  @Override
  protected Serializable doCreate(Session session) {
    Serializable sessionId = this.generateSessionId(session);
    this.assignSessionId(session, sessionId);
    this.saveSession(session);
    return sessionId;
  }

  @Override
  protected Session doReadSession(Serializable sessionId) {
    if (sessionId == null) {
      ExceptionLogger.error("myloan-manager", "session id is null");
      return null;
    }

    Session s = (Session) SerializeUtils.deserialize(redisManager.get(this.getByteKey(sessionId)));
    return s;
  }

  /**
   * 获得byte[]型的key
   * 
   * @param key
   * @return
   */
  private byte[] getByteKey(Serializable sessionId) {
    String preKey = this.keyPrefix + sessionId;
    return preKey.getBytes();
  }

  public RedisManager getRedisManager() {
    return redisManager;
  }

  public void setRedisManager(RedisManager redisManager) {
    this.redisManager = redisManager;

    /**
     * 初始化redisManager
     */
    this.redisManager.init();
  }

  /**
   * Returns the Redis session keys prefix.
   * 
   * @return The prefix
   */
  public String getKeyPrefix() {
    return keyPrefix;
  }

  /**
   * Sets the Redis sessions key prefix.
   * 
   * @param keyPrefix The prefix
   */
  public void setKeyPrefix(String keyPrefix) {
    this.keyPrefix = keyPrefix;
  }


}
