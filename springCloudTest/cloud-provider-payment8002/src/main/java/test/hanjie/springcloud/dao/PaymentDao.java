package test.hanjie.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import test.hanjie.springcloud.entities.Payment;

/**
 * Created by 10568 on 2020/10/16.
 */
@Mapper
public interface PaymentDao {
    //写操作
    public int create(Payment payment);

    //读操作
    public Payment getPaymentById(@Param("id") Long id);
}