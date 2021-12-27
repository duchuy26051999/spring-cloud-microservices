package com.fnkaya.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("auth-list", GatewayRoutes.AUTH_ROUTE)
            .route("auth-login", GatewayRoutes.AUTH_LOGIN_ROUTE)
            .route("auth-signup", GatewayRoutes.AUTH_SIGNUP_ROUTE)
            .build();
    }
}
