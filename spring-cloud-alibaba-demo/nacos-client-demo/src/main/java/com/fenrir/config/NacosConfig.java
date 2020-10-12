package com.fenrir.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

/**
 * nacos配置，主要用户获取公共配置
 * @author fenrir
 *
 */
@Configuration
public class NacosConfig {
	
	@Value("${spring.cloud.nacos.config.server-addr}")
	private String serverAddr = "127.0.0.1:8848";

	@Bean
	public ConfigService configService() throws NacosException {
		Properties properties = new Properties();
		properties.put("serverAddr", serverAddr);
		return NacosFactory.createConfigService(properties);
	}
	
}