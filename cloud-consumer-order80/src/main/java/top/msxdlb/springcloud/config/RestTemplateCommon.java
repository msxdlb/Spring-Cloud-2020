package top.msxdlb.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lb on 2020/4/14
 */
@Configuration
public class RestTemplateCommon {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
