package com.gudonghei.springcloud.dao;

import com.gudonghei.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/15 15:26
 */
@Mapper
public interface PaymentDao {
    public int createPayment(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
