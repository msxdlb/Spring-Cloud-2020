package top.msxdlb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Lb on 2020/4/20
 */
//@SpringCloudApplication
@SpringBootApplication
@EnableFeignClients // 作用：启用feign客服端
@EnableCircuitBreaker  //SpringCloud中使用断路器，需要加上此注解
public class HystrixConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerMain80.class, args);
    }
}
