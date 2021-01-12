package com.gudonghei.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName: LoadBalanced
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/22 15:39
 */
public interface LoadBalanced {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
