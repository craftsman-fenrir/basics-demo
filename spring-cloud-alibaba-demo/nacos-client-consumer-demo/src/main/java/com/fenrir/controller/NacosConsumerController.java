package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosConsumerController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${spring.application.name}")
	private String appName;

	/**
	 * 通过RestTemplate调用微服务提供者
	 * @return
	 */
	@GetMapping(value = "/echo/app/name")
	public String echo() {
		//使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
		ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-client-provider-demo");
		
		String url = String.format(
			"http://%s:%s/provider/echo/%s", 
			serviceInstance.getHost(), 
			serviceInstance.getPort(), 
			appName
		);
		
		return restTemplate.getForObject(url, String.class);
	}

}