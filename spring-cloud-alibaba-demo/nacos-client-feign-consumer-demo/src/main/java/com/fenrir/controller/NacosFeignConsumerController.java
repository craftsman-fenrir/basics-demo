package com.fenrir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fenrir.service.NacosFeignConsumerService;

@RestController
public class NacosFeignConsumerController {

	@Autowired
    private NacosFeignConsumerService nacosFeignConsumerService;

    @GetMapping(value = "/consumer/echo")
    public String echo() {
        return nacosFeignConsumerService.echo("Hi Feign");
    }

}