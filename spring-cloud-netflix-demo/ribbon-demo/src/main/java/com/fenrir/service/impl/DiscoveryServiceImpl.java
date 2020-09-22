package com.fenrir.service.impl;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;

import com.fenrir.entity.BasicListResponseGenericityVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.DataVO;
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
	public BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> discovery() {
		// 通过微服务名调用api
		ParameterizedTypeReference<BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>>> 
			parameterizedTypeReference = new 
		ParameterizedTypeReference<BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>>>(){};
		
		// 请求头
        HttpHeaders headers = new HttpHeaders();
        MimeType mimeType = MimeTypeUtils.parseMimeType("application/json");
        MediaType mediaType = new MediaType(mimeType.getType(), mimeType.getSubtype(), Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        
        // 请求参数
//        HttpEntity<A> entity = new HttpEntity<>(requestBody, headers);
        
        // 发送请求
        ResponseEntity<BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>>> resultEntity = 
        		restTemplate.exchange("http://EUREKA-CLIENT-DEMO/discovery", HttpMethod.GET, null, parameterizedTypeReference);
		
        return resultEntity.getBody();
//		return restTemplate.getForObject("http://EUREKA-CLIENT-DEMO/discovery", String.class);
	}

}