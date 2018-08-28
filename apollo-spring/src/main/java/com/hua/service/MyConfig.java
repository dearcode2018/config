/**
  * @filename MyConfig.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.hua.bean.ConfigBean;

 /**
 * @type MyConfig
 * @description 
 * @author qianye.zheng
 */
@Configuration
@EnableApolloConfig
public class MyConfig
{
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Bean
	public ConfigBean get()
	{
		return new ConfigBean();
	}
	
}
