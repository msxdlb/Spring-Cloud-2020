package top.msxdlb.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;
import top.msxdlb.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lb on 2020/4/20
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public RespResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getById(id);
        if(payment == null){
            return new RespResult<>(444, "查询为空");
        }
        return RespResult.success(payment);
    }

    @GetMapping("/payment/hystrix/ok/{id}")
    public RespResult<Payment> paymentFeignTimeout(@PathVariable("id") Integer id) {
        try {
            TimeUnit.SECONDS.sleep(4); //让线程睡4秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment = paymentService.getById(id);
        if(payment == null){
            return new RespResult<>(444, "查询为空");
        }
        return RespResult.success(payment);
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentInfo_CircuitBreak(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数;");
        }
        String num = UUID.randomUUID().toString();
        return "线程池" + Thread.currentThread().getName() + "调用成功，流水号" + num;
    }

}
