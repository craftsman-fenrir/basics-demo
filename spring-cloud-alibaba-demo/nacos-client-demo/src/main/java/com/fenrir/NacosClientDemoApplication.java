package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableDiscoveryClient - spring cloud配置，把该项目注册到注册中心
 * @RefreshScope - nacos配置，开启动态刷新配置
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class NacosClientDemoApplication {

	// 访问http://ip:port/actuator/nacos-discovery可以看到nacos的微服务信息

	public static void main(String[] args) {
        SpringApplication.run(NacosClientDemoApplication.class, args);
    }

}