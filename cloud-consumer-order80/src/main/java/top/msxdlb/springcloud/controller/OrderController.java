package top.msxdlb.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;

import javax.annotation.Resource;

/**
 * Created by Lb on 2020/4/14
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENY_URL = "http://localhost:8001";

    @Resource
    RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public RespResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENY_URL + "payment/create", payment, RespResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public RespResult<Payment> getPayment(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENY_URL + "payment/get/" + id, RespResult.class);
    }
}
