package com.xw.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-08 20:00
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----PaymentFallbackService fall back back_paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-----PaymentFallbackService fall back back_paymentInfo_timeout";
    }
}
