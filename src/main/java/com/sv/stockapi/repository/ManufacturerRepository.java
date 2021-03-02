package com.sv.stockapi.repository;

import com.sv.stockapi.repository.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    List<Manufacturer> findAll();
}