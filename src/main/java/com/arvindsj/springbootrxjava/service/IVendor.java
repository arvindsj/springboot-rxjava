package com.arvindsj.springbootrxjava.service;

import com.arvindsj.springbootrxjava.domain.Vendor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface IVendor {
    Flux<Vendor> findAllVendors();
    Mono<Vendor> createVendor(Vendor vendor);
    Mono<Optional<Vendor>> getVendorById(String id);
}
