/**
  * @filename ConfigBean.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


 /**
 * @type ConfigBean
 * @description 
 * @author qianye.zheng
 */
@Configuration
public class ConfigBean
{
	/*
	 * 在Bean中用  @Value标注相应的属性，
	 * 默认冒号后面为默认值
	 */
	@Value("${config_001:defaultValue001}")
	private String testValue;

	/**
	 * @return the testValue
	 */
	public final String getTestValue()
	{
		return testValue;
	}

	/**
	 * @param testValue the testValue to set
	 */
	public final void setTestValue(String testValue)
	{
		this.testValue = testValue;
	}
	
}
