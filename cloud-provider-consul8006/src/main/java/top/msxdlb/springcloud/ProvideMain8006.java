package top.msxdlb.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Lb on 2020/4/15
 */
@SpringBootApplication
@MapperScan("top.msxdlb.springcloud.mapper")
@EnableDiscoveryClient
public class ProvideMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(ProvideMain8006.class, args);
    }
}
