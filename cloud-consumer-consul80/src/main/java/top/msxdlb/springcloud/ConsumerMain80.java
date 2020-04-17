package top.msxdlb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Lb on 2020/4/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class);
    }
}
