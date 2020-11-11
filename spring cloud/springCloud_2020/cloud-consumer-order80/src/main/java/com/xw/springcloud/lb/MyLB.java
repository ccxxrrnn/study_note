package com.xw.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-06 14:56
 */

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (this.atomicInteger.compareAndSet(current,next));  //CAS 取不到值就一直自旋
        System.out.println("++++++++++++第几次访问次数next"+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
