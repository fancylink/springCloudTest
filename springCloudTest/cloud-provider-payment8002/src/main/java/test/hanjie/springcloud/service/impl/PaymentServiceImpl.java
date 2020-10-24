package test.hanjie.springcloud.service.impl;

import org.springframework.stereotype.Service;
import test.hanjie.springcloud.dao.PaymentDao;
import test.hanjie.springcloud.entities.Payment;
import test.hanjie.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * Created by 10568 on 2020/10/16.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    //写操作
    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    //读操作
    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}