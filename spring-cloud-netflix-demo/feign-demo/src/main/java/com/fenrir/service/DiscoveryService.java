package com.fenrir.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * service - 使用feign调用其他微服务
 * @author fenrir
 *
 */
@FeignClient(value = "EUREKA-CLIENT-DEMO")
public interface DiscoveryService {

	@GetMapping(value = "/discovery")
	String discovery();
	
}