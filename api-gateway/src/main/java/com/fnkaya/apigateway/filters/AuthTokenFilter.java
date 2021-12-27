package com.fnkaya.apigateway.filters;

import io.jsonwebtoken.Jwts;
import java.util.Objects;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthTokenFilter extends AbstractGatewayFilterFactory<AuthTokenFilter.Config> {

    public AuthTokenFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return onFailure(exchange);
            }

            String authToken = Objects.requireNonNull(request.getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
            String jwtToken = authToken.replace("Bearer ", "");

            if (!this.validateJwtToken(jwtToken)) {
                return onFailure(exchange);
            }

            return chain.filter(exchange);
        });
    }

    private boolean validateJwtToken(String token) {
        String subject = Jwts.parser()
            .setSigningKey("secret_token")
            .parseClaimsJws(token)
            .getBody()
            .getSubject();

        return subject != null && !subject.isEmpty();
    }

    private Mono<Void> onFailure(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    public static class Config {

    }

}
