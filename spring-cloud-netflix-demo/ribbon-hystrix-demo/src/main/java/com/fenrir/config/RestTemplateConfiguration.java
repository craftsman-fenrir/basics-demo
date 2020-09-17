package com.fenrir.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate配置
 * @Configuration spring boot配置，把该class设置为spring的配置
 * @author fenrir
 *
 */
@Configuration
public class RestTemplateConfiguration {

	/**
	 * 实例化restTemplate，并交给spring管理
	 * @LoadBalanced 开启均衡负载
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}