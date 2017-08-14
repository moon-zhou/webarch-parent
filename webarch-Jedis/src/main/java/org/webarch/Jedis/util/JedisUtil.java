/**  
 * Project Name:webarch-Jedis  
 * File Name:JedisUtil.java  
 * Package Name:org.webarch.Jedis.util  
 * Date:2017年8月13日下午8:45:18  
 * Copyright (c) 2017, ayimin1989@163.com All Rights Reserved.  
 *  
*/

package org.webarch.Jedis.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName:JedisUtil <br/>
 * Function: java 操作 redis封装类. <br/>
 * Reason: ADD REASON. <br/>
 * Date: 2017年8月13日 下午8:45:18 <br/>
 * 
 * @author moon-zhou
 * @version
 * @since JDK 1.8
 * @see
 */
public class JedisUtil {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	private JedisUtil() {
	}

	private static class RedisUtilHolder {
		private static final JedisUtil instance = new JedisUtil();
	}

	public static JedisUtil getInstance() {
		return RedisUtilHolder.instance;
	}

	private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();

	private static JedisPool getPool(String ip, int port) {
		String key = ip + ":" + port;
		JedisPool pool = null;
		if (!maps.containsKey(key)) {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(RedisConfig.MAX_ACTIVE);
			config.setMaxIdle(RedisConfig.MAX_IDLE);
			config.setMaxWaitMillis(RedisConfig.MAX_WAIT);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);

			pool = new JedisPool(config, ip, port, RedisConfig.TIMEOUT);
			maps.put(key, pool);
		} else {
			pool = maps.get(key);
		}
		return pool;
	}

	public Jedis getJedis(String ip, int port) {
		Jedis jedis = null;
		int count = 0;
		do {
			try {
				jedis = getPool(ip, port).getResource();
			} catch (Exception e) {
				logger.error("get redis master1 failed!", e);
//				getPool(ip, port).returnBrokenResource(jedis);
				getPool(ip, port).close();
			}
		} while (jedis == null && count < RedisConfig.RETRY_NUM);
		return jedis;
	}

	public void closeJedis(Jedis jedis, String ip, int port) {
		if (jedis != null) {
//			getPool(ip, port).returnResource(jedis);
			getPool(ip, port).close();
		}
	}

}
