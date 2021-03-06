package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableEurekaClient - eureka配置，把该服务配置为eureka注册中心的客户端
 * @EnableFeignClients - feign核心配置，开启feign功能
 * feign默认集成ribbon，feign是面向接口的，ribbon是面向服务的
 * feign更像是对ribbon + restTemplate的优化
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);
	}

}