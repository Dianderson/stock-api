package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
    Page<Stock> findAll(Pageable pageable);
}
