package com.xw.springcloud.service.Impl;

import com.xw.springcloud.dao.PaymentDao;
import com.xw.springcloud.entities.Payment;
import com.xw.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-02 21:15
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
