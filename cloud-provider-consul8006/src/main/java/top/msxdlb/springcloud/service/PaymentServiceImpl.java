package top.msxdlb.springcloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.msxdlb.springcloud.bean.entity.Payment;
import top.msxdlb.springcloud.mapper.PaymentMapper;

/**
 * Created by Lb on 2020/4/15
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}
