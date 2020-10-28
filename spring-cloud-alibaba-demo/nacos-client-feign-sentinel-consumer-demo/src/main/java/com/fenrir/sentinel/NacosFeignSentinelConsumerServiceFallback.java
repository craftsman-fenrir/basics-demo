package com.fenrir.sentinel;

import org.springframework.stereotype.Component;

import com.fenrir.service.NacosFeignSentinelConsumerService;

/**
 * sentinel配置
 * @Component spring配置，把该class设置为spring的组件（不是bean，所以不会放到bean容器）
 * @author fenrir
 *
 */
@Component
public class NacosFeignSentinelConsumerServiceFallback implements NacosFeignSentinelConsumerService {

	/**
	 * 发生熔断时执行
	 */
	@Override
	public String echo(String message) {
		return "echo fallback";
	}

}