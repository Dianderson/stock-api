package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Page<Address> findAll(Pageable pageable);
}