package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableEurekaServer - eureka配置，把该服务配置为eureka注册中心的服务端
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(EurekaServerDemoApplication.class, args);
    }

}