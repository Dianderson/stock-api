package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Supply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplyRepository extends CrudRepository<Supply, Long> {
    List<Supply> findAll();
}
