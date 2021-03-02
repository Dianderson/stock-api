package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Supplier> findAll();
}
