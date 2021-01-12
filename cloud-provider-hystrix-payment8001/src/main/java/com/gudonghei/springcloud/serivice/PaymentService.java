package com.gudonghei.springcloud.serivice;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/23 10:20
 */
@Service
public class PaymentService {

    public String paymentInfo_Ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Ok" + id +"\t";
    }

    public String paymentInfo_TimeOut(Integer id) {
        //        int a = 10/0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOut" + id +"\t耗时间3秒";
    }

}
