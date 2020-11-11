package com.xw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-06 10:44
 */

@RestController
@Slf4j
public class PaymentController {

    @Value( value = "${server.port}")
    private String serverPort;

    @GetMapping( value = "/payment/consul")
    public String PaymentConsul(){
        return "spring cloud consul" + serverPort+ "  UUID :"+UUID.randomUUID().toString();
    }
}
