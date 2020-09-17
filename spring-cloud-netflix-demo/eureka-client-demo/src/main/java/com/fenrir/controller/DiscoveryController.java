package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller - 服务发现
 * @author fenrir
 *
 */
@RestController
public class DiscoveryController {

	@Value("${spring.application.name}")
    private String applicationName;
	
	@Value("${server.port}")
    private String port;

	@GetMapping(value = "/discovery")
	public String sayHi() {
		return String.format(applicationName + "的端口是" + port);
	}
	
}