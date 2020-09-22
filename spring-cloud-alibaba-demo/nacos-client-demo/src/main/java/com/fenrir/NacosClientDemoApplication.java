package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableDiscoveryClient - spring cloud配置，把该项目注册到注册中心
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientDemoApplication {

	// 访问http://ip:port/actuator/nacos-discovery可以看到nacos的微服务信息
	
	public static void main(String[] args) {
        SpringApplication.run(NacosClientDemoApplication.class, args);
    }

//	nacos已经跑通，研究下nocos的详细配置以及集成ribbon跟feign，研究下nacos的服务配置
//	JAX-RS是什么?
    @RestController
    public class EchoController {
        @GetMapping(value = "/echo/{message}")
        public String echo(@PathVariable String message) {
            return "Hello Nacos Discovery " + message;
        }
    }
	
}