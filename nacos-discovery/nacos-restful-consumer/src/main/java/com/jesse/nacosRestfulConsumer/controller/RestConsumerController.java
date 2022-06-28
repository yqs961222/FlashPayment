package com.jesse.nacosRestfulConsumer.controller;

import com.jesse.service1Api.service.Service1Api;
import com.jesse.service2Api.service.Service2Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @Author: Jesse Y
 * @Date: 2022-06-23 15:30
 */
@RestController
@Slf4j(topic = "jes.RestConsumerController")
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

    /**
     * 指定服务名
     */
    String serviceID = "nacos-restful-provider";

    /**
     * 通过负载均衡发现地址，流程是从服务发现中心拿nacos-restful-provider服务的列表，通过负载均衡算法获取一个地址
     */
    @Resource
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/service1")
    public String service1() {
        RestTemplate restTemplate = new RestTemplate();

        // 发现一个地址
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceID);

        // 获取一个http://开头的地址， 包括ip和端口
        URI uri = serviceInstance.getUri();
        String result = restTemplate.getForObject(uri + "/service", String.class);
        return "consumer invoke: " + result;
    }


    /**
     * dubbo的Reference注解将接口注入进来，生成了这个接口的客户端代理对象，使用这个代理对象来实现远程调用服务
     */
    @org.apache.dubbo.config.annotation.Reference
    Service2Api service2Api;

    @GetMapping("/service2")
    public String service2() {
        // 远程调用dubboService2
        log.debug("dubbo invoke start...");
        String s = service2Api.dubboService2();
        return "consumer dubbo invoke: " + s;
    }


    @org.apache.dubbo.config.annotation.Reference
    Service1Api service1Api;

    @GetMapping("/service3")
    public String service3() {
        // 远程调用dubboService1
        log.debug("dubbo invoke start...");
        String s = service1Api.dubboService1();
        return "consumer dubbo invoke: " + s;
    }

    /**
     * 注入配置文件上下文
     */
    @Resource
    ConfigurableApplicationContext applicationContext;

    @GetMapping("/configs")
    public String getConfig() {
        // common.name 是nacos配置中心的nacos-restful-consumer.yaml里的配置项
        return applicationContext.getEnvironment().getProperty("common.name");
    }

}
