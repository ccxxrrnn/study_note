package com.xw.springcloud.dao;

import com.xw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-02 21:02
 */

@Mapper
public interface PaymentDao {

    public int creat(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
