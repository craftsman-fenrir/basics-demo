package com.fenrir.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 
 * @Configuration spring boot配置，把该class设置为spring的配置
 * @EnableAuthorizationServer oauth2服务端授权配置，把该服务设置为oauth2认证和授权服务器
 * @author fenrir
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	/**
	 * 数据源
	 * @return
	 */
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 基于jdbc实现的token数据源
	 * @return
	 */
	@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
	
	/**
	 * 基于jdbc实现的客户端信息服务
	 * @return
	 */
	@Bean
    public ClientDetailsService jdbcClientDetailsService() {
		// 设置令牌
        return new JdbcClientDetailsService(dataSource);
    }

	/**
	 * 令牌配置
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// 设置令牌
        endpoints.tokenStore(tokenStore());
	}

	/**
	 * 客户端信息配置
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// 设置客户端配置
		clients.withClientDetails(jdbcClientDetailsService());
//        clients
//	        // 使用内存设置
//	        .inMemory()
//	        // 客户端标识
//	        .withClient("client")
//	        // 客户端安全码
//	        .secret(passwordEncoder.encode("secret"))
//	        // 客户端授权类型
//	        .authorizedGrantTypes("authorization_code")
//	        // 客户端授权范围
//	        .scopes("app")
//	        // 注册回调地址
//	        .redirectUris("http://www.funtl.com");
	}
	
	// spring security oauth框架默认url
	// /oauth/authorize：授权端点
	// /oauth/token：令牌端点
	// /oauth/confirm_access：用户确认授权提交端点
	// /oauth/error：授权服务错误信息端点
	// /oauth/check_token：用于资源服务访问的令牌解析端点
	// /oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话

}