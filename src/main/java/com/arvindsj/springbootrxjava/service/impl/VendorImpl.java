package com.arvindsj.springbootrxjava.service.impl;

import com.arvindsj.springbootrxjava.domain.Vendor;
import com.arvindsj.springbootrxjava.repository.VendorRepository;
import com.arvindsj.springbootrxjava.service.IVendor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class VendorImpl implements IVendor {
    private VendorRepository vendorRepository;

    public VendorImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Flux<Vendor> findAllVendors() {
        return Flux.fromIterable(vendorRepository.findAll());
    }

    @Override
    public Mono<Vendor> createVendor(final Vendor vendor) {
        return Mono.just(vendorRepository.save(vendor));
    }

    @Override
    public Mono<Optional<Vendor>> getVendorById(String id) {
        return Mono.just(vendorRepository.findById(Integer.parseInt(id)));
    }
}
