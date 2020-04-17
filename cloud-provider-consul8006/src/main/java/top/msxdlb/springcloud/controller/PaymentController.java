package top.msxdlb.springcloud.controller;

import com.mysql.cj.util.TimeUtil;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;
import top.msxdlb.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lb on 2020/4/15
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public RespResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getById(id);
        log.info("查询结果为：" + payment);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (payment != null) {
            return RespResult.success(payment);
        } else {
            return new RespResult<>(444, "查询为空");
        }
    }
}
