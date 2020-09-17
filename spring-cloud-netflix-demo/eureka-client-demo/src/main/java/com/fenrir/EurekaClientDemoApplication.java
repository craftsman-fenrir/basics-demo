package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableEurekaClient - eureka配置，把该服务配置为eureka注册中心的客户端
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientDemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(EurekaClientDemoApplication.class, args);
    }
	
}