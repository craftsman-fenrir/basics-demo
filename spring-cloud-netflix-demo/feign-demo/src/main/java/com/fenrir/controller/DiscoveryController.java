package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fenrir.service.DiscoveryService;

/**
 * controller - 调用其他微服务
 * @author fenrir
 *
 */
@RestController
public class DiscoveryController {

	@Autowired
	private DiscoveryService discoveryService;

	@GetMapping(value = "/discovery")
	public String discovery() {
		return discoveryService.discovery();
	}
	
}