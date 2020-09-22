package com.fenrir.service;

import org.springframework.stereotype.Service;

import com.fenrir.entity.BasicListResponseGenericityVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.DataVO;

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
	BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> discovery();
	
}