package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer>findAll();
}
