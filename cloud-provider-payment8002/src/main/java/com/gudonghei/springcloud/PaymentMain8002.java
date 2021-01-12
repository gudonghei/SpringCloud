package com.gudonghei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: PaymentMain8002
 * @Description: 主启动类
 * @Author: ZJH
 * @Date: 2020/10/13 14:08
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.gudonghei.springcloud"})
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
