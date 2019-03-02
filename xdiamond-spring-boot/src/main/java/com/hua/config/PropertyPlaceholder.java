/**
  * @filename PropertyPlaceholder.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @type PropertyPlaceholder
 * @description 
 * @author qianye.zheng
 */
public class PropertyPlaceholder extends PropertyPlaceholderConfigurer
{
	
	/* 全局配置 */
	private static final Map<String, String> properties = new HashMap<String, String>();
	
	/**
	 * @description 
	 * @param beanFactoryToProcess
	 * @param props
	 * @throws BeansException
	 * @author qianye.zheng
	 */
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException
	{
		super.processProperties(beanFactoryToProcess, props);
		for (Object key : props.keySet())
		{
			final String keyStr = key.toString();
			properties.put(keyStr, props.getProperty(keyStr));
		}
	}

	/**
	 * 
	 * @description 读取值
	 * @param key 键
	 * @return
	 * @author qianye.zheng
	 */
	public static final String getProperty(final String key)
	{
		return properties.get(key);
	}
	
	/**
	 * 
	 * @description 更新值
	 * @param key 键
	 * @param value 值
	 * @author qianye.zheng
	 */
	public static final void update(final String key, final String value)
	{
		properties.put(key, value);
	}
	
	/**
	 * 
	 * @description 
	 * @param key
	 * @author qianye.zheng
	 */
	public static final void remove(final String key)
	{
		properties.remove(key);
	}
	
}
