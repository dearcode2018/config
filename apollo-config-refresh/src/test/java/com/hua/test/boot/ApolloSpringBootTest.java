/**
 * 描述: 
 * ApolloSpringBootTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.boot;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.hua.ApplicationStarter;
import com.hua.bean.ConfigBean;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ApolloSpringBootTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
// for Junit 5.x
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration(value = "src/main/webapp")
@SpringBootTest(classes = {ApplicationStarter.class})
//@MapperScan(basePackages = {"com.hua.mapper"})
public final class ApolloSpringBootTest extends BaseTest {

	@ApolloConfig
	private Config config;
	
	@Resource
	private ConfigBean configBean;
	
	/*
	 * 在Bean中用  @Value标注相应的属性，
	 * 默认冒号后面为默认值
	 */
	@Value("${config_001:defaultValue001}")
	private String testValue;	
	
	@Value("${a.b:defaultValue001}")
	private String value3;	
	
	@Value("${a.c:defaultValue001}")
	private String value4;	
		
	
	/*
	配置方式1: 
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextConfiguration(locations = {
			"classpath:conf/xml/spring-bean.xml", 
			"classpath:conf/xml/spring-config.xml", 
			"classpath:conf/xml/spring-mvc.xml", 
			"classpath:conf/xml/spring-service.xml"
		})
	@ExtendWith(SpringExtension.class)
	
	配置方式2: 	
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextHierarchy({  
		 @ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),  
		 @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")  
		}) 
	@ExtendWith(SpringExtension.class)
	 */
	
	/**
	 * 而启动spring 及其mvc环境，然后通过注入方式，可以走完 spring mvc 完整的流程.
	 * 
	 */
	//@Resource
	//private UserController userController;
	
	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testValueAnnotation4() {
		try {
			System.out.println(value4);
			
		} catch (Exception e) {
			log.error("testValueAnnotation4 =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testValueAnnotation3() {
		try {
			System.out.println(value3);
			
		} catch (Exception e) {
			log.error("testValueAnnotation3 =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testValueAnnotation() {
		try {
			System.out.println(testValue);
			
		} catch (Exception e) {
			log.error("testValueAnnotation =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testValueAnnotation2() {
		try {
			/*
			 * 使用 	@Value("${config_001:defaultValue001}")
			 * 注入的值，在Apollo管理后台修改发布之后实时生效
			 * 通过 apollo.autoUpdateInjectedSpringProperties=false 可以关闭此功能，默认是开启
			 */
			while (true)
			{
				Thread.sleep(5 * 1000);
				System.out.println(testValue);
			}
			
		} catch (Exception e) {
			log.error("testValueAnnotation2 =====> ", e);
		}
	}	
		
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
			//System.setProperty("env", "DEV");
			
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
			//System.setProperty("env", "DEV");
			
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
			//System.setProperty("env", "DEV");
			log.info("testConfigBean =====> " + configBean.getTestValue());
			
		} catch (Exception e) {
			log.error("testConfigBean =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
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
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
			
			
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
	@DisplayName("testCommon")
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
	@DisplayName("testSimple")
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
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
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
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
	}

}
