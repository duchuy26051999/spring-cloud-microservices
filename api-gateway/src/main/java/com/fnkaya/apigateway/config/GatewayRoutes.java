package com.fnkaya.apigateway.config;

import com.fnkaya.apigateway.filters.AuthTokenFilter;
import com.fnkaya.apigateway.filters.AuthTokenFilter.Config;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class GatewayRoutes {

    private static String authServiceUrl = "lb://auth-service";

    private static final GatewayFilter TOKEN_FILTER;

    private GatewayRoutes() {}

    static {
        TOKEN_FILTER = new AuthTokenFilter().apply(new Config());
    }

    public static final Function<PredicateSpec, Buildable<Route>> AUTH_ROUTE =
        r -> r.path("/auth")
            .and().method(HttpMethod.GET)
            .filters(f -> f.filter(TOKEN_FILTER))
            .uri(authServiceUrl);

    public static final Function<PredicateSpec, Buildable<Route>> AUTH_LOGIN_ROUTE =
        r -> r.path("/login")
            .and().method(HttpMethod.POST)
            .uri(authServiceUrl);

    public static final Function<PredicateSpec, Buildable<Route>> AUTH_SIGNUP_ROUTE =
        r -> r.path("/auth")
            .and().method(HttpMethod.POST)
            .uri(authServiceUrl);
}
