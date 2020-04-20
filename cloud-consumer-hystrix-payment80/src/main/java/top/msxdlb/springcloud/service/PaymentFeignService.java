package top.msxdlb.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;

/**
 * Created by Lb on 2020/4/20
 */
@FeignClient(value = "cloud-hystrix-provider-service",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
    RespResult<Payment> getPaymentById(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    RespResult<Payment> paymentFeignTimeout(@PathVariable("id") Integer id);


}
