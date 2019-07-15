/**
  * @filename HelloWorldController.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hua.entity.User;
import com.hua.service.ConfigService;

 /**
 * @type HelloWorldController
 * @description 
 * @author qianye.zheng
 */
/*
 * @RestController(value = 对象的名称，并非是接口路径) 
 */
/* 动态刷新配置 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController extends BaseController
{
	
	@Resource
	private ConfigService configService;
	
	//@Value("${system.name}")
	private String value;
	
	/* application.name.yaml|properties|xml|html|text 只存在公共文件中 */
	@Value("${abc.nameCommon:default11}")
	private String valueCommon;
	
	/**
	 * 
	 * @description 
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@RefreshScope
	@GetMapping({"/get", "/get23"})
	public User get(final String id)
	{
		System.out.println("valueCommon= " + valueCommon);
		User user = new User();
		user.setNickname("张三");
		user.setPassword("12345678");
		
		return user;
	}
	
	/**
	 * 
	 * @description 
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@GetMapping({"/add"})
	public User add(final String id)
	{
		User user = new User();
		user.setNickname("张三");
		user.setPassword("12345678");
		configService.insertToFirst();
		
		return user;
	}
	
	/**
	 * 
	 * @description 
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value = "/get2", method = RequestMethod.GET)
	public User get2(final String id)
	{
		User user = new User();
		user.setNickname("张三");
		user.setPassword("123456");
		//System.out.println(JacksonUtil.writeAsString(user));
		
		return user;
	}
	
	/**
	 * 
	 * @description 
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value = "/get3", method = RequestMethod.GET)
	public User get3(final String id)
	{
		User user = new User();
		user.setNickname("张三");
		user.setPassword("123456");
		//System.out.println(JacksonUtil.writeAsString(user));
		
		return user;
	}
	
}
