package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);
}
