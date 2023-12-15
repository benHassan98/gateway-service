package com.odinbook.gatewayservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Value("${postService.url}")
    private String postServiceUrl;
    @Value("${accountService.url}")
    private String accountServiceUrl;
    @Value("${chatService.url}")
    private String chatServiceUrl;
    @Value("${notificationsService.url}")
    private String notificationsServiceUrl;


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){

        return builder.routes()
                .route("postService"
                        ,
                        r-> r
                                .path("/postService/**")
                                .filters(f->f
                                        .stripPrefix(1)
                                        .removeRequestHeader("Origin")
                                        .addRequestHeader("Origin","http://localhost:8080")
                                        .dedupeResponseHeader(
                                                "Access-Control-Allow-Origin",
                                                "RETAIN_FIRST"
                                                )
                                        .dedupeResponseHeader(
                                                "Access-Control-Allow-Credentials",
                                                "RETAIN_UNIQUE"
                                        )
                                )
                                .uri(postServiceUrl)

                )
                .route("accountService",r-> r
                        .path("/accountService/**")
                        .filters(f->f
                                .stripPrefix(1)
                                .removeRequestHeader("Origin")
                                .addRequestHeader("Origin","http://localhost:8080")
                                .dedupeResponseHeader(
                                        "Access-Control-Allow-Origin",
                                        "RETAIN_FIRST"
                                )
                                .dedupeResponseHeader(
                                        "Access-Control-Allow-Credentials",
                                        "RETAIN_UNIQUE"
                                )
                        )
                        .uri(accountServiceUrl)



                )
                .route("chatService",r-> r
                        .path("/chatService/**")
                        .filters(f->f
                                .stripPrefix(1)
                                .removeRequestHeader("Origin")
                                .addRequestHeader("Origin","http://localhost:8080")
                                .dedupeResponseHeader(
                                        "Access-Control-Allow-Origin",
                                        "RETAIN_FIRST"
                                )
                                .dedupeResponseHeader(
                                        "Access-Control-Allow-Credentials",
                                        "RETAIN_UNIQUE"
                                )
                        )
                        .uri(chatServiceUrl)



                )
                .route("notificationsService",r-> r
                        .path("/notificationsService/**")
                        .filters(f->f
                                .stripPrefix(1)
                                .removeRequestHeader("Origin")
                                .addRequestHeader("Origin","http://localhost:8080")
                                .dedupeResponseHeader(
                                        "Access-Control-Allow-Origin",
                                        "RETAIN_FIRST"
                                )
                                .dedupeResponseHeader(
                                        "Access-Control-Allow-Credentials",
                                        "RETAIN_UNIQUE"
                                )
                        )
                        .uri(notificationsServiceUrl)

                )

                .build();

    }

}
