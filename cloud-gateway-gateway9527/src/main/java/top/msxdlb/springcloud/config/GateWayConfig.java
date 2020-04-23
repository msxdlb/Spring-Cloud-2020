package top.msxdlb.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By LB on 2020/4/22.
 * 编码方式配置 网关 路由
 */
@Configuration
public class GateWayConfig {

    private static final String PAYMENT_ROUTE_1 = "payment_route_1";
    private static final String PATTERNS_1 = "/payment/hystrix/ok/**";
    private static final String URI_1 = "http://localhost:8888/payment/hystrix/ok/**";

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
//
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes(); //构建路由
//        return routes.route(PAYMENT_ROUTE_1,
//                i -> i.path(PATTERNS_1).uri(URI_1)).build();
//    }
}
