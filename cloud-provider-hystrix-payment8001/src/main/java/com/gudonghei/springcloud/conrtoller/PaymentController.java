package com.gudonghei.springcloud.conrtoller;

import com.gudonghei.springcloud.entities.CommonResult;
import com.gudonghei.springcloud.entities.Payment;
import com.gudonghei.springcloud.serivice.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/23 10:26
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String getPaymentInfo_Ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Ok(id);
        log.info("*********结果输出" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String getPaymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*********结果输出" + result);
        return result;
    }
}
