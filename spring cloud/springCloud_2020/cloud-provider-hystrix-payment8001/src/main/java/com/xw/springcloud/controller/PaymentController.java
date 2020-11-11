package com.xw.springcloud.controller;

import com.xw.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-08 17:49
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfo_ok(id);
        log.info("+++++++result:" + res);
        return res;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfo_timeout(id);
        log.info("+++++++result:" + res);
        return res;
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String res=paymentService.PaymentCircuitBreaker(id);
        log.info("++++result   : "+res);
        return res;
    }
}
