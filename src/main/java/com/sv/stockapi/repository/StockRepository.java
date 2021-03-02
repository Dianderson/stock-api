package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Long> {
    List<Stock> findAll();
}
