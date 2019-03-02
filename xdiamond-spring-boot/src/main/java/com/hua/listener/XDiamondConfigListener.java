/**
  * @filename XDiamondConfigListener.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.listener;

import org.springframework.stereotype.Component;

import com.hua.config.PropertyPlaceholder;

import io.github.xdiamond.client.annotation.AllKeyListener;
import io.github.xdiamond.client.event.ConfigEvent;

/**
 * @type XDiamondConfigListener
 * @description 
 * @author qianye.zheng
 */
@Component
public class XDiamondConfigListener
{

	
		/**
		 * 
		 * @description 单个key监听器
		 * @param event
		 * @author qianye.zheng
		 */
		//@OneKeyListener(key = "a.name")
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
			/*
			 * 删除后 则变为null
			 */
			System.out.println(event.getKey() + ": oldValue =  " + event.getOldValue() + 
					", newValue = " + event.getValue());
			if (null == event.getValue())
			{ // 移除掉key
				System.out.println("配置项 key: " + event.getKey() + ", value = " + event.getValue() + " 被删除");
				PropertyPlaceholder.remove(event.getKey());
			}
			PropertyPlaceholder.update(event.getKey(), event.getValue());
			// 刷新配置
			//cwa.refresh();
			//propertyPlaceholderConfigurer.
		}
	
	
}
