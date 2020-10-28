package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fenrir.service.NacosFeignSentinelConsumerService;

/**
 * controller - 微服务消费者
 * @author fenrir
 *
 */
@RestController
public class NacosFeignSentinelConsumerController {

	/**
	 * feign
	 */
	@Autowired
    private NacosFeignSentinelConsumerService nacosFeignSentinelConsumerService;

	/**
	 * 消费服务端
	 * @return
	 */
    @GetMapping(value = "/consumer/echo")
    public String echo() {
        return nacosFeignSentinelConsumerService.echo("Hi Feign");
    }

}