package com.fenrir;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableCaching - spring boot cache配置，开启缓存
 * @ComponentScan - spring boot配置，管理路径下带spring注解的class
 * @Filter - spring boot配置，@ComponentScan的子注解，用来设定过滤规则让@ComponentScan来决定如何排除和只包含
 * @ComponentScans - spring boot配置，管理多个@ComponentScan
 * @MapperScan - mybatis扫描配置
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.fenrir.dao")
//@ComponentScan("com.fenrir")
//@ComponentScans(value = {@ComponentScan("com.fenrir.dao"), @ComponentScan("com.fenrir.service")})
public class SpringBootMybatisDemoApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisDemoApplication.class, args);
    }

}