package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    Page<Supplier> findAll(Pageable pageable);

    Supplier findByCnpj(String cnpj);
}
