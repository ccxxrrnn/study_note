package com.xw.springcloud.service;

import com.xw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-02 21:14
 */

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
