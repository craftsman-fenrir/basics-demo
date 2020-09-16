package com.fenrir;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableCaching - spring boot cache配置，开启缓存
 * @MapperScan - mybatis扫描配置
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.fenrir.dao")
public class SpringBootMybatisRedisDemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisRedisDemoApplication.class, args);
    }
	
}