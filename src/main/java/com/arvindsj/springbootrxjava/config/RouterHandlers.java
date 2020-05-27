package com.arvindsj.springbootrxjava.config;

import com.arvindsj.springbootrxjava.domain.Vendor;
import com.arvindsj.springbootrxjava.service.IVendor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RouterHandlers {

    private IVendor vendorService;

    public RouterHandlers(IVendor vendorService) {
        this.vendorService = vendorService;
    }

    public Mono<ServerResponse> findAll(final ServerRequest serverRequest) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(vendorService.findAllVendors(), Vendor.class);
    }

    public Mono<ServerResponse> createVendor(final ServerRequest serverRequest) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(serverRequest.bodyToMono(Vendor.class).flatMap(vendorService::createVendor), Vendor.class);
    }

    public Mono<ServerResponse> getVendorById(final ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok().body(vendorService.getVendorById(id), Vendor.class);
    }
}
