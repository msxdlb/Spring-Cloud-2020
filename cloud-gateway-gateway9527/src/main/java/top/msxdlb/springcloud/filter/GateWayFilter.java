package top.msxdlb.springcloud.filter;

import cn.hutool.json.JSON;
import io.netty.buffer.ByteBufAllocator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create By LB on 2020/4/22.
 */
@Component
@Slf4j
public class GateWayFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE; //高优先级的过滤器,防止某些系统内置的过滤器可能也会去读body，导致只能读一次的情况
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("========= 进入网关 过滤器 ==================");
        MediaType contentType = exchange.getRequest().getHeaders().getContentType(); //获取类型 application/json
        if (contentType == null) {
            return chain.filter(exchange);
        } else {
            String token = exchange.getRequest().getHeaders().getFirst("token"); //获取请求头里面的token
            if(token.startsWith("cloud-gateway")){
                // 进行业务逻辑操作  此处略
            }
            Mono<DataBuffer> join = DataBufferUtils.join(exchange.getRequest().getBody());//获取上下文monoSubscriberContext
            return join.flatMap(i -> { //返回一个新的Mono
                DataBufferUtils.retain(i);
                Flux<DataBuffer> cachedFlux  = Flux.defer(() ->  //读取 body数据 Flux<DataBuffer>
                        Flux.just(i.slice(0, i.readableByteCount())));
                ServerHttpRequestDecorator mutatedRequest  = new ServerHttpRequestDecorator(exchange.getRequest()) { //ServerHttpRequestDecorator这个请求装饰器对request进行包装
                    @Override
                    public Flux<DataBuffer> getBody() {     //重写getBody方法, 后面过滤链就能实现对body的多次读取
                        return cachedFlux ;
                    }
                };
                ServerWebExchange mutatedExchange =
                        exchange.mutate().request(mutatedRequest).build(); //用新的ServerHttpRequest修改exchage，这样body就可以多次读取
                return chain.filter(mutatedExchange);
            });
        }
    }
}
