package com.kazu.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author akifova
 * @since 21.01.2021
 */
@RefreshScope
@Configuration
public class RouterConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(RouterConfiguration.class);

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authentication", r-> r.path("/api/auth")
                        .and().uri("http://localhost:8090/api/auth")
                )
                .build();
    }
}
