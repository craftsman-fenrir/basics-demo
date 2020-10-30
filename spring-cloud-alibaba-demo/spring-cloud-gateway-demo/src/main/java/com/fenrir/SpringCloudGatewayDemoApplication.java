package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableDiscoveryClient - spring cloud配置，把该项目注册到注册中心
 * @EnableFeignClients - feign核心配置，开启feign功能
 * feign默认集成ribbon，feign是面向接口的，ribbon是面向服务的
 * feign更像是对ribbon + restTemplate的优化
 * @RefreshScope - nacos配置，开启动态刷新配置
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RefreshScope
public class SpringCloudGatewayDemoApplication {

	// 访问http://ip:port/actuator/nacos-discovery可以看到nacos的微服务信息

	public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayDemoApplication.class, args);
    }

}