/**
 * 
 */
package com.maiyajf.loan.manage.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.cache.CacheException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import com.maiyajf.base.utils.SerializingUtil;
import com.maiyajf.base.utils.base.BeanUtils;
import com.maiyajf.base.utils.log.ExceptionLogger;

/**
 * @author Jinfm
 * 业务需求使用此REDIS UTIL
 */
public class JedisBisUtil {

	private static final String REDIS_HEADER = "maiya_bis:";

	/**
	 * 根据KEY获取对象
	 * @param key
	 * @return
	 * @throws CacheException
	 */
	public static Object get(String key) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				byte[] byteKey = getCacheKey(key).getBytes();
				byte[] byteValue = jedis.get(byteKey);
				if (byteValue != null) {
					return SerializingUtil.deserialize(byteValue);
				}
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return null;
	}
	
	/**
	 * 根据KEY获取对象,非序列化的值
	 * @param key
	 * @return
	 * @throws CacheException
	 */
	public static Object getNoSerializied(String key) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				Object obj = jedis.get(getCacheKey(key));
				return obj;
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return null;
	}

	/**
	 * 增加
	 * @param key
	 * @param value
	 * @return
	 * @throws CacheException
	 */
	public static Object put(String key, Object value) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				if (key != null && value != null) {
					jedis.set(getCacheKey(key).getBytes(), SerializingUtil.serialize(value));
				}
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return value;
	}

	/**
	 * @Title: putExpire
	 * @Description: 增加并设置有效时间
	 * @return: Object
	 */
	public static Object putExpire(String key, int seconds, Object value) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				if (key != null && value != null) {
					jedis.setex(getCacheKey(key).getBytes(), seconds, SerializingUtil.serialize(value));
				}
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return value;
	}
	
	/**
	 * redis Set集合，新增当个值
	 * @param key
	 * @param value
	 * @return
	 * @throws CacheException
	 */
	public static Object sadd(String key, Object value) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				if (key != null && value != null) {
					jedis.sadd(getCacheKey(key).getBytes(), SerializingUtil.serialize(value));
				}
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return value;
	}

	// /**
	// * redis Set 无序集合新增
	// * @param key
	// * @param values
	// * @return
	// * @throws CacheException
	// */
	// public static Object sadds(String key, List<?> values) throws CacheException {
	// if (StringUtils.isBlank(key)) {
	// return null;
	// } else {
	// Jedis jedis = JedisBisManage.getJedis();
	// try {
	// if (key != null && values != null) {
	// for(Object value:values){
	// jedis.sadd(getCacheKey(key).getBytes(), SerializingUtil.serialize(value));
	// }
	// }
	// } catch (JedisException e) {
	// ExceptionLogger.error(e);
	// } finally {
	// JedisBisManage.returnResource(jedis);
	// }
	// }
	// return key;
	// }
	//
	// /**
	// * 根据Set KEY获取对象集合
	// * @param key
	// * @return
	// * @throws CacheException
	// */
	// public static List<?> smembers(String key) throws CacheException {
	// if (StringUtils.isBlank(key)) {
	// return null;
	// } else {
	// Jedis jedis = JedisBisManage.getJedis();
	// try {
	// byte[] byteKey = getCacheKey(key).getBytes();
	// Set<byte[]> sets = jedis.smembers(byteKey);
	// List<Object> setValues=new ArrayList<Object>();
	// for(Iterator<byte[]>it=sets.iterator();it.hasNext();){
	// byte[] byteValue= it.next();
	// Object o= SerializingUtil.deserialize(byteValue);
	// setValues.add(o);
	// }
	// return setValues;
	// } catch (JedisException e) {
	// ExceptionLogger.error(e);
	// } finally {
	// JedisBisManage.returnResource(jedis);
	// }
	// }
	// return null;
	// }
	/**
	 * 
	 * @param key
	 * @param values
	 * @return
	 * @throws CacheException
	 */
	public static Object zadd(String key, List<?> values) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				if (key != null && values != null) {
					Double i = 0.0d;
					Map<Double, byte[]> map = new HashMap<Double, byte[]>();
					for (Object value : values) {
						map.put(i++, SerializingUtil.serialize(value));
						if (i % 50 == 0) {
							jedis.zadd(getCacheKey(key).getBytes(), map);
							map.clear();
						}
						// jedis.zadd(getCacheKey(key).getBytes(), i++, SerializingUtil.serialize(value));
					}
					if (map.size() > 0) {
						jedis.zadd(getCacheKey(key).getBytes(), map);
					}
				}
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return key;
	}

	/**
	 * 构建有序Redis查询
	 * @param key 
	 * @param start 开始记录数
	 * @param end  结束记录数
	 * @return
	 * @throws CacheException
	 */
	public static Object zrange(String key, int start, int end) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				byte[] byteKey = getCacheKey(key).getBytes();
				if (end == 0) {
					end = -1;
				}
				Set<byte[]> lists = jedis.zrange(byteKey, start, end);
				List<Object> setValues = new ArrayList<Object>();
				for (Iterator<byte[]> it = lists.iterator(); it.hasNext();) {
					byte[] byteValue = it.next();
					Object o = SerializingUtil.deserialize(byteValue);
					setValues.add(o);
				}
				return setValues;
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return null;
	}

	/**
	 * 删除
	 * @param key
	 * @return
	 * @throws CacheException
	 */
	public static Object remove(String key) throws CacheException {
		Object previos = get(key);
		Jedis jedis = JedisBisManage.getJedis();
		try {
			jedis.del(getCacheKey(key).getBytes());
		} catch (JedisException e) {
			ExceptionLogger.error(e);
		} finally {
			JedisBisManage.returnResource(jedis);
		}

		return previos;
	}

	public static Object removeByString(String key) throws CacheException {
		Object previos = get(key);
		Jedis jedis = JedisBisManage.getJedis();
		try {
			jedis.del(key);
		} catch (JedisException e) {
			ExceptionLogger.error(e);
		} finally {
			JedisBisManage.returnResource(jedis);
		}

		return previos;
	}

	/**
	 * 清空
	 * @throws CacheException
	 */
	public void clear(String catalog) throws CacheException {
		byte[] keysPattern;
		if (StringUtils.isNotBlank(catalog)) {
			keysPattern = (REDIS_HEADER + catalog + "*").getBytes();
		} else {
			keysPattern = (REDIS_HEADER + "*").getBytes();
		}
		Jedis jedis = JedisBisManage.getJedis();
		try {
			jedis.del(keysPattern);
		} catch (JedisException e) {
			ExceptionLogger.error(e);
		} finally {
			JedisBisManage.returnResource(jedis);
		}
	}

	/**
	 * 设置Redis失效时间
	 * @throws CacheException
	 */
	public static void expire(String key, int time) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return;
		}
		Jedis jedis = JedisBisManage.getJedis();
		try {
			jedis.expire(getCacheKey(key).getBytes(), time);
		} catch (JedisException e) {
			ExceptionLogger.error(e);
		} finally {
			JedisBisManage.returnResource(jedis);
		}
	}

	/**
	 * 获取redis中的数据量
	 * @return
	 */
	public static int size() {
		if (keys(null) == null)
			return 0;
		return keys(null).size();
	}

	/**
	 * 获取key集合
	 * @return
	 */
	public static Set<String> keys(String catalog) {
		Jedis jedis = JedisBisManage.getJedis();
		Set<byte[]> byteSet;
		if (StringUtils.isNotBlank(catalog)) {
			byteSet = jedis.keys((REDIS_HEADER + catalog + "*").getBytes());
		} else {
			byteSet = jedis.keys((REDIS_HEADER + "*").getBytes());
		}
		Set<String> keys = new HashSet<String>();
		for (byte[] bs : byteSet) {
			keys.add((String) SerializingUtil.deserialize(bs));
		}
		return keys;
	}

	/**
	 * 获取key集合
	 * @return
	 */
	public static Set<String> keysByString(String catalog) {
		Jedis jedis = JedisBisManage.getJedis();
		Set<String> byteSet;
		if (StringUtils.isNotBlank(catalog)) {
			byteSet = jedis.keys((REDIS_HEADER + catalog + "*"));
		} else {
			byteSet = jedis.keys((REDIS_HEADER + "*"));
		}
		Set<String> keys = new HashSet<String>();
		for (String bs : byteSet) {
			keys.add(bs);
		}
		return keys;
	}

	/**
	 * 获取所有的值
	 * @return
	 */
	public static Collection<Object> values(String catalog) {
		Jedis jedis = JedisBisManage.getJedis();
		Set<byte[]> byteSet;
		if (StringUtils.isNotBlank(catalog)) {
			byteSet = jedis.keys((REDIS_HEADER + catalog + "*").getBytes());
		} else {
			byteSet = jedis.keys((REDIS_HEADER + "*").getBytes());
		}
		List<Object> result = new LinkedList<Object>();
		for (byte[] bs : byteSet) {
			result.add(SerializingUtil.deserialize(jedis.get(bs)));
		}
		return result;
	}

	/**
	 * 获取key
	 * @param key
	 * @return
	 */
	private static String getCacheKey(Object key) {
		return REDIS_HEADER + key;
	}

	/**
	 * @Title: setAndGetToken
	 * @Description: 生成一个token值，将token和用户ID保存到redis中，并设置token的失效时间，返回旧token和新生成的token
	 * @param memberId 用户ID
	 * @param time token失效时间
	 * @return: String
	 */
	public static Map<String, String> setAndGetToken(String memberId, int time) {
		Map<String, String> result = new HashMap<>();
		String newToken = null;
		if (!StringUtils.isEmpty(memberId)) {
			String oldToken = (String) JedisBisUtil.get(memberId);
			result.put("oldToken", oldToken);
			newToken = BeanUtils.getUUID();
			JedisBisUtil.putExpire(newToken, time, memberId);
			JedisBisUtil.putExpire(memberId, time, newToken);
			result.put("newToken", newToken);
		}
		return result;
	}

	public static void removeToken(String token) {
		if (!StringUtils.isEmpty(token)) {
			String memberId = (String) JedisBisUtil.get("token");
			JedisBisUtil.remove(token);

			if (!StringUtils.isEmpty(memberId))
				JedisBisUtil.remove(memberId);
		}
	}

	/** 
	 * 方法名：  incr 
	 * 描述：  自增的方法
	 * @author  zhuzheng   
	 * 创建时间：2015年11月20日 下午2:45:04
	 * @param key
	 * @return
	 *
	 */
	public static long incr(String key) {
		Long count = 0l;
		Jedis jedis = JedisBisManage.getJedis();
		try {
			if (key != null) {
				count = jedis.incr(getCacheKey(key));
			}
		} catch (JedisException e) {
			ExceptionLogger.error(e);
		} finally {
			JedisBisManage.returnResource(jedis);
		}
		return count;
	}
	
	/**
	 * 设置Redis失效时间
	 * @throws CacheException
	 */
	/**
	 * 设置Redis失效时间
	 * @throws CacheException
	 */
	public static void expireNoSerializing(String key, int time) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return;
		}
		Jedis jedis = JedisBisManage.getJedis();
		try {
			jedis.expire(getCacheKey(key), time);
		} catch (JedisException e) {
			ExceptionLogger.error(e);
		} finally {
			JedisBisManage.returnResource(jedis);
		}
	}
	
	/**
	 * 删除
	 * @param key
	 * @return
	 * @throws CacheException
	 */
	public static Object removeNoSerializing(String key) throws CacheException {
		long count=0;
		Jedis jedis = JedisBisManage.getJedis();
		try {
			count = jedis.del(getCacheKey(key));
		} catch (JedisException e) {
			ExceptionLogger.error(e);
		} finally {
			JedisBisManage.returnResource(jedis);
		}
		return count;
	}
	
	/** 
	 * 方法名：  ttl 
	 * 描述：  获取key剩余过期时间
	 * @author  zhuzheng   
	 * 创建时间：2015年12月2日 下午6:02:02
	 * @param key
	 * @return
	 * @throws CacheException
	 *
	 */
	public static long ttl(String key) throws CacheException {
		if (StringUtils.isBlank(key)) {
			return 0;
		} else {
			Jedis jedis = JedisBisManage.getJedis();
			try {
				byte[] byteKey = getCacheKey(key).getBytes();
				long time = jedis.ttl(byteKey);
				return time;
			} catch (JedisException e) {
				ExceptionLogger.error(e);
			} finally {
				JedisBisManage.returnResource(jedis);
			}
		}
		return 0;
	}
}
