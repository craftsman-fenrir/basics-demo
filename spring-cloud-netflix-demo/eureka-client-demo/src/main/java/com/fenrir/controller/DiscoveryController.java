package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fenrir.entity.BasicListResponseGenericityVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.DataVO;
import com.fenrir.service.DiscoveryService;

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
	
	@Autowired
	private DiscoveryService discoveryService;

	@GetMapping(value = "/discovery", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> discovery() {
		return discoveryService.discovery();
	}
	
}