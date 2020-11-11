package com.xw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-10 14:50
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getServerPortAndId(@PathVariable Integer id){
        return "服务端口为" + serverPort + "\t"+"id = " + id;
    }
}
