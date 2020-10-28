package com.fenrir.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fenrir.sentinel.NacosFeignSentinelConsumerServiceFallback;

/**
 * service - 使用feign调用其他微服务
 * @author fenrir
 *
 */
@FeignClient(value = "nacos-client-provider-demo", fallback = NacosFeignSentinelConsumerServiceFallback.class)
public interface NacosFeignSentinelConsumerService {

	@GetMapping(value = "/provider/echo/{message}")
    String echo(@PathVariable("message") String message);

}