/**
  * @filename ConfigVo.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

 /**
 * @type ConfigVo
 * @description 
 * @author qianye.zheng
 */
public class ConfigVo
{
	
	private String key;
	
	private String value;
	
	private String description;

	/**
	* @return the key
	*/
	public String getKey()
	{
		return key;
	}

	/**
	* @param key the key to set
	*/
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	* @return the value
	*/
	public String getValue()
	{
		return value;
	}

	/**
	* @param value the value to set
	*/
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	* @return the description
	*/
	public String getDescription()
	{
		return description;
	}

	/**
	* @param description the description to set
	*/
	public void setDescription(String description)
	{
		this.description = description;
	}
	
}
