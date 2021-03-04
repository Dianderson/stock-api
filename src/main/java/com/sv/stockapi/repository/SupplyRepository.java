package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Supply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface SupplyRepository extends CrudRepository<Supply, Long> {
    Page<Supply> findAll(Pageable pageable);
}
