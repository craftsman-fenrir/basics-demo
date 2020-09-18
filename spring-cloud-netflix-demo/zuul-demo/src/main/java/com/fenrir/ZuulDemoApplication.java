package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableEurekaClient - eureka配置，把该服务配置为eureka注册中心的客户端
 * @EnableZuulProxy - zuul配置，开启zuul功能
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulDemoApplication.class, args);
	}

}