package com.sv.stockapi.service;

import com.sv.stockapi.error.exception.EntityNotFoundException;

import com.sv.stockapi.repository.ManufacturerRepository;
import com.sv.stockapi.repository.model.Manufacturer;
import com.sv.stockapi.resource.dto.response.ManufacturerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public List<ManufacturerResponse> findAll() {
        return manufacturerRepository.findAll().stream().map(ManufacturerResponse::of).collect(Collectors.toList());
    }

    public ManufacturerResponse findById(Long id) {
        return manufacturerRepository.findById(id)
                .map(ManufacturerResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Manufacturer with id %s not found", id)));
    }

    public ManufacturerResponse save(Manufacturer manufacturer) {
        return ManufacturerResponse.of(manufacturerRepository.save(manufacturer));
    }

    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }

    public ManufacturerResponse update(Long id, Manufacturer manufacturer) {
        Manufacturer toBeUpdated = manufacturerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Manufacturer with id %s not found", manufacturer.getId())));

        if (!manufacturer.getName().isEmpty()) {
            toBeUpdated.setName(manufacturer.getName());
        }
        if (!manufacturer.getCnpj().isEmpty()) {
            toBeUpdated.setCnpj(manufacturer.getCnpj());
        }
        if (!manufacturer.getEmail().isEmpty()) {
            toBeUpdated.setEmail(manufacturer.getEmail());
        }
        if (manufacturer.getContact().isEmpty()) {
            toBeUpdated.setContact(manufacturer.getContact());
        }
        if (manufacturer.getTelephone().isEmpty()) {
            toBeUpdated.setTelephone(manufacturer.getTelephone());
        }
        if (manufacturer.getAddress() != null) {
            toBeUpdated.setAddress(manufacturer.getAddress());
        }
        return ManufacturerResponse.of(manufacturerRepository.save(toBeUpdated));
    }
}