/**
  * @filename ConfigService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.entity.CollegeStudent;
import com.hua.mapper.auto.CollegeStudentMapper;

/**
 * @type ConfigService
 * @description 
 * @author qianye.zheng
 */
@Service
public class ConfigService
{
	
	@Resource
	private CollegeStudentMapper collegeStudentMapper;
	
	/**
	 * 
	 * @description 
	 * 数据源: second据源
	 * @author qianye.zheng
	 */
	public void insertToFirst()
	{
		CollegeStudent entity = new CollegeStudent();
		entity.setName("赵东来");
		entity.setCredit(new BigDecimal(15.5));
		entity.setBirthday(new Date());
		entity.setAddress("广西省桂林市阳朔县大桂路345号");
		//entity.setType((byte) 1);
		entity.setRemark(null);
		/*
		 * 保存一个实体，null的属性不会保存，会使用数据库默认值
		 *  通常情况下，insertSelectvie使用得较多
		 */
		collegeStudentMapper.insertSelective(entity);
	}	
}
