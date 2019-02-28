/**
  * @filename XDiamondConfigListener.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.listener;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import io.github.xdiamond.client.annotation.AllKeyListener;
import io.github.xdiamond.client.annotation.OneKeyListener;
import io.github.xdiamond.client.event.ConfigEvent;

/**
 * @type XDiamondConfigListener
 * @description 
 * @author qianye.zheng
 */
@Component
public class XDiamondConfigListener
{

	
	
	
    @Resource 
    private PropertyPlaceholderConfigurer propertyPlaceholderConfigurer;
	
		/**
		 * 
		 * @description 单个key监听器
		 * @param event
		 * @author qianye.zheng
		 */
		@OneKeyListener(key = "a.name")
		public void oneKeyListener(final ConfigEvent event)
		{
			System.out.println(event.getKey() + ": oldValue =  " + event.getOldValue() + 
					", newValue = " + event.getValue());
		}
		
		/**
		 * 
		 * @description 所有key监听器
		 * @param event
		 * @author qianye.zheng
		 */
		@AllKeyListener
		public void allKeyListener(final ConfigEvent event)
		{
			// 刷新配置
			//cwa.refresh();
			propertyPlaceholderConfigurer.
		}
	
	
}
