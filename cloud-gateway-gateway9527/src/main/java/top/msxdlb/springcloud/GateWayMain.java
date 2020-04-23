package top.msxdlb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Create By LB on 2020/4/22.
 */
@SpringBootApplication
@EnableFeignClients // 作用：启用feign客服端
public class GateWayMain {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain.class, args);
    }
}


