package com.fenrir.service;

import org.springframework.stereotype.Service;

/**
 * service - 调用其他微服务
 * @author fenrir
 *
 */
@Service
public interface DiscoveryService {

	/**
	 * 服务发现
	 * @return
	 */
	String discovery();
	
}