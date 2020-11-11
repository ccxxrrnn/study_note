package com.xw.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-06 14:54
 */

public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
