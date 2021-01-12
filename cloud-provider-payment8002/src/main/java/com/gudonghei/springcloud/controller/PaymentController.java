package com.gudonghei.springcloud.controller;

import com.gudonghei.springcloud.entities.CommonResult;
import com.gudonghei.springcloud.entities.Payment;
import com.gudonghei.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @ClassName: PaymentController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/15 15:43
 */
//@RestController
//@Slf4j
@SuppressWarnings("all")
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult creat(@RequestBody Payment payment) {
        int result = paymentService.createPayment(payment);
        log.info("*********结果输出" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功," + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }


    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*********结果输出" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功" + serverPort, result);
        } else {
            return new CommonResult(444, "没有查询结果" + id, null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element*****" + element);
        }
        List<ServiceInstance> instances =    discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;

    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
