package com.fenrir.service.impl;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * service - 调用其他微服务
 * @author fenrir
 *
 */
@Service
public class DiscoveryServiceImpl implements DiscoveryService {

	@Autowired
    private RestTemplate restTemplate;
	
	/**
	 * @HystrixCommand hystrix配置，指定熔断时执行的方法
	 */
	@HystrixCommand(fallbackMethod = "error")
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

	public BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> error() {
		BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> basicResponseGenericity = new BasicResponseGenericityVO<>();
		basicResponseGenericity.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		basicResponseGenericity.setMessage("feign hystrix demo调用第三方微服务时出现了异常并且熔断了");
		return basicResponseGenericity;
    }
	
}