package com.xw.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-03 17:56
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //使用LoadBalanced注解赋予RestTemplate负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
