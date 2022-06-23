package com.jesse.nacosRestfulProvider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jesse Y
 * @Date: 2022-06-23 11:34
 */

@RestController
@Slf4j(topic = "jes.log.RestProviderController")
public class RestProviderController {

    @GetMapping(value = "/service")
    public String service() {
        log.debug("provider invoke...");
        return "provider invoke";
    }
}
