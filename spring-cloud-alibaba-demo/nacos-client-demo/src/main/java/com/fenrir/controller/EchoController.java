package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

/**
 * controller - 微服务提供者demo
 * @author fenrir
 *
 */
@RestController
public class EchoController {
	
	@Value("${fenrir.nacos.test-data}")
	private String testData = null;
	
	@Autowired
	private ConfigService configService;
	
	/**
	 * 用来接收消息并返回消息的接口
	 * @param message
	 * @return
	 */
    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable String message) {
        return "Hello Nacos Discovery " + message;
    }
    
    /**
     * 做nacos动态配置测试的接口
     * @return
     * @throws NacosException
     */
    @GetMapping(value = "/getConfig", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getConfig() throws NacosException {
    	// 配置列表的Data Id
		String dataId = "fenrir-test-id";
		// 配置列表的Group
		String group = "DEFAULT_GROUP";
		// 获取配置
		String msg = configService.getConfig(dataId, group, 5000);

        return  new StringBuffer("{\"msg\":\"")
    			.append(msg)
    			.append("\"}")
    			.toString();
    }

}