package top.msxdlb.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.common.RespResult;
import top.msxdlb.springcloud.common.RespResultEnum;
import top.msxdlb.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * Created by Lb on 2020/4/14
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public RespResult create(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);
        log.info("插入结果" + save);
        if (payment != null) {
            return RespResult.success(RespResultEnum.ADD_SUCCESS);
        } else {
            return RespResult.error(RespResultEnum.ADD_ERROR);
        }
    }

    @GetMapping("/zk")
    public String paynmentzk() {
        return "Srping Cloud witch zookeeper" + serverPort;
    }

    @GetMapping("/get/{id}")
    public RespResult getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getById(id);
        log.info("查询结果为：{}", payment);
        if (payment != null) {
            return RespResult.success(RespResultEnum.SEARCH_SUCCESS);
        } else {
            return RespResult.error(RespResultEnum.SEARCH_ERROR);
        }
    }

}
