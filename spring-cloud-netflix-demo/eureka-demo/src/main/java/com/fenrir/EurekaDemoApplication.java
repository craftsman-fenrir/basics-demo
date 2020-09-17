package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableEurekaServer - spring cloud eureka配置，把该服务配置为eureka注册中心
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaDemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(EurekaDemoApplication.class, args);
    }
	
}