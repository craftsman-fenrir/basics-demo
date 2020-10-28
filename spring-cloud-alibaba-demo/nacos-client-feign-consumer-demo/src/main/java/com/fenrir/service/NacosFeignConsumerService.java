package com.fenrir.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-client-provider-demo")
public interface NacosFeignConsumerService {

	@GetMapping(value = "/provider/echo/{message}")
    String echo(@PathVariable("message") String message);

}