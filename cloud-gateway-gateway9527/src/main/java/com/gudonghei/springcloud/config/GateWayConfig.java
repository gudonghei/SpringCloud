package com.gudonghei.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GateWayConfig
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/23 17:17
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder  routes = routeLocatorBuilder.routes();

        /*
         * 代表访问http://localhost:9527/guonei
         * 跳转到http://news.baidu.com/guonei
         * */
        routes.route("route1",
                r->r.path("/lady")
                        .uri("http://news.baidu.com/lady")).build();
        return routes.build();

    }
}
