/**
 * 描述: 
 * ApolloSpringTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.config;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.hua.bean.ConfigBean;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ApolloSpringTest
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
// for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:conf/xml/spring-apollo.xml"})
public final class ApolloSpringTest extends BaseTest {

	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	@ApolloConfig
	private Config config;
	
	@Resource
	private ConfigBean configBean;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadConfig() {
		try {
			// 设置环境
			System.setProperty("env", "DEV");
			
			String key = "config_001"; //key
			String defaultValue = "defaultValue"; //默认值，读取不到配置就会使用默认值，建议都加上默认值
			String value = config.getProperty(key, defaultValue);
			
			log.info("testReadConfig =====> value = " + value);
			
		} catch (Exception e) {
			log.error("testReadConfig =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testListenEvent() {
		try {
			// 设置环境
			System.setProperty("env", "DEV");
			
			String key = "config_001"; //key
			String defaultValue = "defaultValue"; //默认值，读取不到配置就会使用默认值，建议都加上默认值
			ConfigChangeListener listener = new ConfigChangeListener() {
				/**
				 * @description 
				 * @param changeEvent
				 * @author qianye.zheng
				 */
				@Override
				public void onChange(ConfigChangeEvent changeEvent)
				{
					System.out.println("Changes for namespace " + changeEvent.getNamespace());
					for (String key : changeEvent.changedKeys())
					{
						ConfigChange change = changeEvent.getChange(key);
						System.out.println(String.format("found change - key : %s, oldValue: %s, "
								+ "newValue: %s, changeType: %s",  change.getPropertyName(), 
								change.getOldValue(), change.getNewValue(), change.getChangeType()));
					}
				}
			};
			config.addChangeListener(listener);
		
			Thread.sleep(20 * 1000);
		} catch (Exception e) {
			log.error("testListenEvent =====> ", e);
		}
	}
	
	/** * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testConfigBean() {
		try {
			/*
			 * 在Bean中响应属性中
			 * 标注
			 */
			// 设置环境
			System.setProperty("env", "DEV");
			log.info("testConfigBean =====> " + configBean.getTestValue());
			
		} catch (Exception e) {
			log.error("testConfigBean =====> ", e);
		}
	}
	
	/** * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSpringJunit() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSpringJunit =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			Set<String> keys = config.getPropertyNames();
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
