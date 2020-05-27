package com.arvindsj.springbootrxjava.repository;

import com.arvindsj.springbootrxjava.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {}
