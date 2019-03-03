/**
  * @filename XDiamondConfiguration.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hua.util.ReadProperties;
import com.hua.util.StringUtil;

import io.github.xdiamond.client.XDiamondConfig;
import io.github.xdiamond.client.spring.XDiamondConfigFactoryBean;

/**
 * @type XDiamondConfiguration
 * @description 
 * @author qianye.zheng
 */
@Configuration
public class XDiamondConfiguration
{
	
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Bean
	public PropertyPlaceholderConfigurer propertyConfigurer()
	{
		final PropertyPlaceholderConfigurer bean = new PropertyPlaceholder();
		try
		{
			final XDiamondConfig config = xDiamondConfig().getObject();
			bean.setProperties(config.getProperties());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return bean;
	}
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Bean
	public XDiamondConfigFactoryBean xDiamondConfig()
	{
		String activeProfile = System.getProperty("spring.profiles.active");
		if (StringUtil.isEmpty(activeProfile))
		{
			 // 默认开发环境
			activeProfile = "dev";
		}
		final ReadProperties props = new ReadProperties("/conf/project.properties");
		final XDiamondConfigFactoryBean bean = new XDiamondConfigFactoryBean();
		bean.setServerHost(props.getProperty(activeProfile + ".xdiamond.server.host"));
		// 端口，和管理后台端口不同
		bean.setServerPort(props.getProperty(activeProfile + ".xdiamond.server.port"));
		bean.setGroupId(props.getProperty(activeProfile + ".xdiamond.client.groupId"));
		bean.setArtifactId(props.getProperty(activeProfile + ".xdiamond.client.artifactId"));
		bean.setVersion(props.getProperty(activeProfile + ".xdiamond.client.version"));
		// 环境参数: dev | test | yuprod | prod
		bean.setProfile(props.getProperty(activeProfile + ".xdiamond.client.profile"));
		// 数据传输密钥，在客户端指定
		bean.setSecretKey(props.getProperty(activeProfile + ".xdiamond.client.secretKey"));
		// 以指数退避方式计算重连时间间隔
		bean.setRetryIntervalSeconds("5");
		// 最大重试时间间隔
		bean.setMaxRetryIntervalSeconds(props.getProperty(activeProfile + ".xdiamond.maxRetry.intervalSeconds"));
		// 最大重试次数，默认会无限重试
		bean.setMaxRetryTimes("");
		/*
		 * 是否将配置同步到System Properties中，开启可以实现在自定义properties文件中
		引用XDiamond的配置 例如 testKey=${keyFraomXdiamond}
		注意: 因为System Properties为公共属性，所以例如在同一个tomcat实例中，
		则会全局有效
		 */
		bean.setbSyncToSystemProperties("true");
		
		return bean;
	}
	
}
