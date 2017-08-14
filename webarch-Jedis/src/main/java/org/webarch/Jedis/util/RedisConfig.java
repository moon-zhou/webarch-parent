/**  
 * Project Name:webarch-Jedis  
 * File Name:RedisConfig.java  
 * Package Name:org.webarch.Jedis.util  
 * Date:2017年8月13日下午9:05:16  
 * Copyright (c) 2017, ayimin1989@163.com All Rights Reserved.  
 *  
*/

package org.webarch.Jedis.util;

/**
 * ClassName:RedisConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年8月13日 下午9:05:16 <br/>
 * 
 * @author admin
 * @version
 * @since JDK 1.8
 * @see
 */
public class RedisConfig {
	
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	public static int	MAX_ACTIVE	= 1024;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	public static int	MAX_IDLE	= 200;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	public static int	MAX_WAIT	= 10000;

	public static int	TIMEOUT		= 10000;

	public static int	RETRY_NUM	= 5;
}
