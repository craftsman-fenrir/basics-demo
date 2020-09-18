package com.fenrir.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fenrir.service.DiscoveryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * service - 调用其他微服务
 * @author fenrir
 *
 */
@Service
public class DiscoveryServiceImpl implements DiscoveryService {

	@Autowired
    private RestTemplate restTemplate;
	
	/**
	 * @HystrixCommand hystrix配置，指定熔断时执行的方法
	 */
	@HystrixCommand(fallbackMethod = "error")
	@Override
	public String discovery() {
		// 通过微服务名调用api
		return restTemplate.getForObject("http://EUREKA-CLIENT-DEMO/discovery", String.class);
	}

	public String error() {
        return "ribbon hystrix demo调用其他微服务时发生了异常并熔断";
    }
	
}