package com.fenrir.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fenrir.entity.BasicListResponseGenericityVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.DataVO;
import com.fenrir.service.DiscoveryService;

/**
 * service - 服务发现
 * @author fenrir
 *
 */
@Service
public class DiscoveryServiceImpl implements DiscoveryService {

	@Value("${spring.application.name}")
    private String applicationName;
	
	@Value("${server.port}")
    private String port;
	
	@Override
	public BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> discovery() {
		BasicListResponseGenericityVO<DataVO> listResponse = new BasicListResponseGenericityVO<>();
		List<DataVO> list = new ArrayList<>();
		DataVO data = new DataVO(
			applicationName, port, new BigDecimal(99.02), new Timestamp(System.currentTimeMillis())
		);
		list.add(data);
		listResponse.setContent(list);
		listResponse.setPageNumber(1);
		listResponse.setPageSize(10);
		listResponse.setTotal(1);
		listResponse.setPageIndex(1);
		listResponse.setTotalPage(1);
		
		BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> response = new BasicResponseGenericityVO<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.getReasonPhrase());
		response.setData(listResponse);
		
		return response;
	}

}
