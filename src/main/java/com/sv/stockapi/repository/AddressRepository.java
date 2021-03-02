package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAll();
}