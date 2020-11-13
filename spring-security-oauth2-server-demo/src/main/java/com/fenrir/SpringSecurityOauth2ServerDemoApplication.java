package com.fenrir;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * oauth2认证和授权服务器，用于获取token
 * @SpringBootApplication - spring boot启动配置
 * @MapperScan - mybatis扫描配置
 * @author fenrir
 *
 */
@SpringBootApplication
@MapperScan("com.fenrir.dao")
public class SpringSecurityOauth2ServerDemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2ServerDemoApplication.class, args);
    }

}