package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    Page<Manufacturer> findAll(Pageable pageable);
}