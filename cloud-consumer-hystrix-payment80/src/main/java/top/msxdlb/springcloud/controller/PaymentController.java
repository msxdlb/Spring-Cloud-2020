package top.msxdlb.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;
import top.msxdlb.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * Created by Lb on 2020/4/20
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    RespResult<Payment> getPaymentById(@PathVariable("id") Integer id){
        log.info("我是使用的Feign");
        return  paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout/{id}")
    RespResult<Payment> paymentFeignTimeout(@PathVariable("id") Integer id){
        log.info("我是使用的Feign");
        return  paymentFeignService.paymentFeignTimeout(id);
    }
}
