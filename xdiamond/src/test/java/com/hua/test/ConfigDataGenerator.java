/**
 * 描述: 
 * ConfigDataGenerator.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.hua.entity.ConfigVo;
import com.hua.util.FileUtil;
import com.hua.util.JacksonUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.ReadProperties;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ConfigDataGenerator
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
// for Junit 5.x
public final class ConfigDataGenerator extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void generateJson() {
		try {
			String path = "/input.properties";
			ReadProperties props = new ReadProperties(path);
			Properties properties = props.getProps();
			Set<Object> keys = properties.keySet();
			List<ConfigVo> vos = new ArrayList<>();
			ConfigVo vo = null;
			for (Object key : keys)
			{
				vo = new ConfigVo();
				vo.setKey(key.toString());
				vo.setValue(props.getProperty(vo.getKey()));
				vos.add(vo);
			}
			final String outputPath = ProjectUtil.getAbsolutePath("/doc/output.json", true);
			// 输出json数据
			FileUtil.writeString(outputPath, JacksonUtil.writeAsString(vos));
			
		} catch (Exception e) {
			log.error("generateJson =====> ", e);
		}
	}
		

}
