package com.arvindsj.springbootrxjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class VendorRoutes {

    @Bean
    public RouterFunction<ServerResponse> route(RouterHandlers handler) {
        return RouterFunctions
            .route(GET("/vendors/all").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
            .andRoute(POST("/vendor/create").and(accept(MediaType.APPLICATION_JSON)), handler::createVendor)
            .andRoute(GET("/vendor/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getVendorById)
        ;
    }
}
