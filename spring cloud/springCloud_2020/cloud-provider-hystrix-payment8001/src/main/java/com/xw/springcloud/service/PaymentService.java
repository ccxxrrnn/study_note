package com.xw.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-08 17:44
 */

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池 "+Thread.currentThread().getName()+"  paymentInfo_ok: id = " +id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(Integer id) {
        int timeout=3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        return "线程池 "+Thread.currentThread().getName()+"  paymentInfo_timeout: id = " +id+"  耗时  "+timeout+"  秒钟";
//        int age=10/0;
        return "线程池 " + Thread.currentThread().getName() + "  paymentInfo_timeout: id = " + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池 "+Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler: id = " +id;
    }


    //====服务熔断


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //失败率到达多少跳闸
    })
    public String PaymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("+++++id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试   0   .     0"+id;
    }
}
