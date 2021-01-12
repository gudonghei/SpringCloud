package com.gudonghei.springcloud.controller;

import com.gudonghei.springcloud.entities.CommonResult;
import com.gudonghei.springcloud.entities.Payment;
import com.gudonghei.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
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
    @GetMapping(value = "/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功";
    }


}
