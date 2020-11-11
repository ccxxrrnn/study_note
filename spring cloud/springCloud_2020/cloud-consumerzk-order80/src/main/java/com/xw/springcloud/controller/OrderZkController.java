package com.xw.springcloud.controller;

import com.xw.springcloud.entities.CommonResult;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-05 17:35
 */

@RestController
@Slf4j
public class OrderZkController {

    public static final String PAYMENT_URL= "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping( value = "/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }

}
