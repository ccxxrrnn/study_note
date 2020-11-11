package com.xw.springcloud.controller;

import com.xw.springcloud.entities.CommonResult;
import com.xw.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-03 17:56
 */

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL= "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping( value = "/consumer/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }

}
