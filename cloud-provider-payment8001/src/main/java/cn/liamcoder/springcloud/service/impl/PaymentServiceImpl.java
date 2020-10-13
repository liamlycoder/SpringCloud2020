package cn.liamcoder.springcloud.service.impl;

import cn.liamcoder.springcloud.dao.PaymentDao;
import cn.liamcoder.springcloud.entities.Payment;
import cn.liamcoder.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
