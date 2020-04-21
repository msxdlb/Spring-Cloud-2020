package top.msxdlb.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;

/**
 * Created by Lb on 2020/4/20
 */
//@Component
@Service
public class PaymentFallbackService implements PaymentFeignService {

    @Override
    public RespResult<Payment> getPaymentById(Integer id) {
        return RespResult.error(500, " getPaymentById 方法  触发熔断降级  ");
    }

    @Override
    public RespResult<Payment> paymentFeignTimeout(Integer id) {
        return RespResult.error(500, " paymentFeignTimeout 方法 触发熔断降级");
    }
}
