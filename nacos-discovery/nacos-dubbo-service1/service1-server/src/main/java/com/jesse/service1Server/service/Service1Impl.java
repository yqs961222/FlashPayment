package com.jesse.service1Server.service;

import com.jesse.service1Api.service.Service1Api;
import com.jesse.service2Api.service.Service2Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;

/**
 * @Author: Jesse Y
 * @Date: 2022-06-28 10:58
 */
@Slf4j(topic = "jes.Service1Impl")
@org.apache.dubbo.config.annotation.Service
public class Service1Impl implements Service1Api {

    @Reference
    Service2Api service2Api;

    @Override
    public String dubboService1() {
        log.debug("Service1Impl invoke service2Api...");
        String s = service2Api.dubboService2();
        return "dubboService1 invoke | " + s;
    }
}
