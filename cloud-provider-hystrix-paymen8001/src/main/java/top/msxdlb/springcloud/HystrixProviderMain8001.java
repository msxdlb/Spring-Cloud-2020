package top.msxdlb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Lb on 2020/4/20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker  //SpringCloud中使用断路器，需要加上此注解
public class HystrixProviderMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProviderMain8001.class, args);
    }
}
