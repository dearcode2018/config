/**
  * @filename GlobalConfig.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.config;

 /**
 * @type GlobalConfig
 * @description 
 * @author qianye.zheng
 */
public class GlobalConfig
{
	
	/**
	 * 
	 * @description 读取值
	 * @param key 键
	 * @return
	 * @author qianye.zheng
	 */
	public static final String getProperty(final String key)
	{
		return PropertyPlaceholder.getProperty(key);
	}

}