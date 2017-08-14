package org.webarch.Jedis.base;

import org.junit.Assert;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * 
 * ClassName: RedisStudy001 <br/>  
 *     使用jedis基本操作Redis
 *     连接，存值
 * date: 2017年8月13日 下午8:38:26 <br/>  
 *  
 * @author admin  
 * @version   
 * @since JDK 1.8
 */
public class RedisStudy001 {
    
    /**
     * 测试无需要密码登录
     */
    @Test
    public void testConAndSet() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        
        jedis.set("name", "moon-zhou");
        
        Assert.assertEquals("moon-zhou", jedis.get("name"));
        
        jedis.close();
    }
    
    @Test
    public void testConPwdAndSet() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("root");
        
        jedis.set("name", "moon-zhou 2");
        
        Assert.assertEquals("moon-zhou 2", jedis.get("name"));
        
        jedis.close();
    }
}
