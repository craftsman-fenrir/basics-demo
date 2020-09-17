package com.fenrir.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fenrir.hystrix.DiscoveryHystrix;

/**
 * service - 使用feign调用其他微服务
 * @author fenrir
 *
 */
@FeignClient(value = "EUREKA-CLIENT-DEMO", fallback = DiscoveryHystrix.class)
public interface DiscoveryService {

	@GetMapping(value = "/discovery")
	String discovery();
	
}