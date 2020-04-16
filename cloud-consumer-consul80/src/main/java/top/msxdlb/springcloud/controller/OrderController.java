package top.msxdlb.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;

import javax.annotation.Resource;

/**
 * Created by Lb on 2020/4/16
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENY_URL = "http://cloud-payment-service";

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public RespResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENY_URL + "/payment/get/" + id, RespResult.class);
    }
}
