package com.fenrir.service;

import org.springframework.stereotype.Service;

import com.fenrir.entity.BasicListResponseGenericityVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.DataVO;

/**
 * service - 服务发现
 * @author fenrir
 *
 */
@Service
public interface DiscoveryService {

	BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> discovery();
	
}