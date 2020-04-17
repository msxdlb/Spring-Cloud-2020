package top.msxdlb.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;

/**
 * Created by Lb on 2020/4/16
 */
@Component
@FeignClient("cloud-payment-service")
public interface OrderService {


    @GetMapping("/payment/get/{id}")
    public RespResult<Payment> getPaymentById(@PathVariable("id") Integer id);
}
