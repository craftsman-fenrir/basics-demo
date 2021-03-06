package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fenrir.service.NacosFeignConsumerService;

/**
 * controller - 微服务消费端
 * @author fenrir
 *
 */
@RestController
public class NacosFeignConsumerController {

	/**
	 * feign
	 */
	@Autowired
    private NacosFeignConsumerService nacosFeignConsumerService;

	/**
	 * 消费服务端
	 * @return
	 */
    @GetMapping(value = "/consumer/echo")
    public String echo() {
        return nacosFeignConsumerService.echo("Hi Feign");
    }

}