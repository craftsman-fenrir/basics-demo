package com.fenrir.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 微服务消费者配置
 * @Configuration spring boot配置，把该class设置为spring的配置
 * @author fenrir
 *
 */
@Configuration
public class NacosConsumerConfiguration {

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}