package com.fenrir.hystrix;

import org.springframework.stereotype.Component;

import com.fenrir.service.DiscoveryService;

/**
 * feign的hystrix配置
 * @Component spring配置，把该class设置为spring的组件（不是bean，所以不会放到bean容器）
 * @author fenrir
 *
 */
@Component
public class DiscoveryHystrix implements DiscoveryService {

	@Override
	public String discovery() {
		return "feign hystrix demo调用第三方微服务时出现了异常并且熔断了";
	}
	
}