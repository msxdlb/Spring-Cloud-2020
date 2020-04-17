package top.msxdlb.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;
import top.msxdlb.springcloud.service.OrderService;

import javax.annotation.Resource;

/**
 * Created by Lb on 2020/4/16
 */
@RestController
@Slf4j
public class OrderController {

    /**
     * 使用 restTemplate 方式调用
     */
    public static final String PAYMENY_URL = "http://cloud-payment-service";

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public RespResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENY_URL + "/payment/get/" + id, RespResult.class);
    }
    //======================================================================================================================
    //======================================================================================================================

    /**
     * 使用 Feign 方式调用
     */

    @Resource
    private OrderService orderService;

    @GetMapping("/feign/payment/get/{id}")
    public RespResult<Payment> getPayment(@PathVariable("id") Integer id) {
        log.info("<<<<<<<<<<<  我是通过feign >>>>>>>>>>>>");
        return orderService.getPaymentById(id);
    }

}
