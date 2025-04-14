package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.filter.GlobalFilter;

@Configuration
public class GatewayConfig {

	@Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("auth-service", r -> r.path("/auth/**").uri("lb://auth"))
            
            .route(r -> r.path("/contact-api/**").uri("lb://CONTACT"))
            .route(r -> r.path("/campaign-api/**").uri("lb://CAMPAIGN"))
            .route(r -> r.path("/auth-api/**").uri("lb://AUTH"))
            
            .route("contact-service", r -> r.path("/contact/**")
                .filters(f -> f.filter(jwtAuthFilter))
                .uri("lb://contact"))
            .route("campaign-service", r -> r.path("/campaign/**")
                .filters(f -> f.filter(jwtAuthFilter))
                .uri("lb://campaign"))
            .build();
    }
    
    @Bean
    GlobalFilter loggingFilter() {
        return new LoggingGatewayFilter();
    }
}
