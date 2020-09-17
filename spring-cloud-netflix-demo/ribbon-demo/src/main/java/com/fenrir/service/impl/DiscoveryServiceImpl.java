package com.fenrir.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fenrir.service.DiscoveryService;

/**
 * service - 调用其他微服务
 * @author fenrir
 *
 */
@Service
public class DiscoveryServiceImpl implements DiscoveryService {

	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public String discovery() {
		// 通过微服务名调用api
		return restTemplate.getForObject("http://EUREKA-CLIENT-DEMO/discovery", String.class);
	}

}