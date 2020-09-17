package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableDiscoveryClient - spring cloud配置，曾经支持任何注册中心
 * 现在eureka已经不支持了，因为@EnableEurekaClient内部不在注解@EnableDiscoveryClient
 * @EnableEurekaClient - eureka配置，把该服务配置为eureka注册中心的客户端
 * @author fenrir
 *
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
public class EurekaClientDemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(EurekaClientDemoApplication.class, args);
    }
	
}