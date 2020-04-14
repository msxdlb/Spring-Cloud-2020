package top.msxdlb.springcloud.service.impl;

import top.msxdlb.springcloud.mapper.PaymentMapper;
import top.msxdlb.springcloud.service.PaymentService;
import top.msxdlb.springcloud.bean.entity.Payment;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Lb on 2020/4/14
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}
