package com.jesse.service2Server.service;

import com.jesse.service2Api.service.Service2Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Jesse Y
 * @Date: 2022-06-28 10:58
 */
@Slf4j(topic = "jes.Service2Impl")
@org.apache.dubbo.config.annotation.Service
public class Service2Impl implements Service2Api {

    @Override
    public String dubboService2() {
        log.debug("Service2Impl invoke...");
        return "dubboService2";
    }
}
