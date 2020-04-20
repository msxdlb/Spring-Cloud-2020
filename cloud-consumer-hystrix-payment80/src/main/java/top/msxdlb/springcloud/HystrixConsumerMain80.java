package top.msxdlb.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Lb on 2020/4/20
 */
@SpringBootApplication
@EnableFeignClients // 作用：启用feign客服端
@EnableHystrix      // 作用：启动熔断降级服务
public class HystrixConsumerMain80 {
}
