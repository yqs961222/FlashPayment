package com.jesse.nacosRestfulConsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Jesse Y
 * @Date: 2022-06-23 15:30
 */
@RestController
@Slf4j
public class RestConsumerController {

    /**
     * 需要知道服务提供方ip地址
     */
    @Value("${provider.address}")
    private String provider;


    @GetMapping("/service")
    public String service() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://" + provider + "/service", String.class);
        return "consumer invoke: " + result;
    }

}
