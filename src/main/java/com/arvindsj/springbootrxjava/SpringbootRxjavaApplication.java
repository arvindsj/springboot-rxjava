package com.arvindsj.springbootrxjava;

import com.arvindsj.springbootrxjava.domain.Vendor;
import com.arvindsj.springbootrxjava.repository.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
public class SpringbootRxjavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRxjavaApplication.class, args);
    }

    @Bean
    CommandLineRunner initializeVendors(VendorRepository vendorRepository) {
        return args -> {
            vendorRepository.deleteAll();
            vendorRepository.saveAll(IntStream.rangeClosed(1, 100).mapToObj(i -> new Vendor("vendor" + i)).collect(Collectors.toList()));
            log.info("Vendors :: {}", vendorRepository.findAll());
        };

    }
}


