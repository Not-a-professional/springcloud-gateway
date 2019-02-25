package com.example.springcloudgateway.Routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiRoute {
    @Bean
    public RouteLocator testRoute(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(
                        r -> r.path("/api**")
                                .filters(
                                        f ->
                                                f.rewritePath("/apitest", "/api/test")
                                                 .rewritePath("/apibaiduimages2word", "/api/baidu/images2word"))
                                .uri("lb://API") //与服务发现配合使用时必须使用大写的服务名，网络协议使用lb
                        .id("test_route2")
                )
                .build();
    }
}
