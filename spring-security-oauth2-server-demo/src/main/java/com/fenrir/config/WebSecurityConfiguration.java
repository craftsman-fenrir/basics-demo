package com.fenrir.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fenrir.service.UserDetailsServiceImpl;

/**
 * 网络安全配置
 * @Configuration spring boot配置，把该class设置为spring的配置
 * @EnableWebSecurity spring security配置，使安全配置起作用
 * @EnableGlobalMethodSecurity spring security配置，设置全局拦截
 * @author fenrir
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * 密码加密/解析器
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * 用户信息服务
	 */
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	/**
	 * 身份验证管理器
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义认证与授权
        auth.userDetailsService(userDetailsService());
		
		// 在内存中做身份验证
//		auth.inMemoryAuthentication()
//		.withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN")
//		.and()
//		.withUser("user").password(passwordEncoder().encode("123456")).roles("USER");
	}

	/**
	 * 网络安全配置
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
	    web.ignoring().antMatchers("/oauth/check_token");
	}

}