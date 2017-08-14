/**  
 * Project Name:webarch-Jedis  
 * File Name:Log4jTest.java  
 * Package Name:org.webarch.Jedis  
 * Date:2017年8月13日下午8:58:07  
 * Copyright (c) 2017, ayimin1989@163.com All Rights Reserved.  
 *  
*/

package org.webarch.Jedis;

import org.apache.log4j.Logger;

/**
 * ClassName:Log4jTest <br/>
 * Function: 测试log4j. <br/>
 * Date: 2017年8月13日 下午8:58:07 <br/>
 * 
 * @author moon-zhou
 * @version
 * @since JDK 1.8
 * @see
 */
public class Log4jRunTest {

	private static Logger logger = Logger.getLogger(Log4jRunTest.class);

	public static void main(String[] args) {
		
		// 记录debug级别的信息
		logger.debug("This is debug message.");
		
		// 记录info级别的信息
		logger.info("This is info message.");
		
		// 记录error级别的信息
		logger.error("This is error message.");
	}

}
