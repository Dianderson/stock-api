package com.sv.stockapi.service;

import com.sv.stockapi.repository.ManufacturerRepository;
import com.sv.stockapi.repository.model.Manufacturer;
import com.sv.stockapi.resource.dto.response.ManufacturerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final AddressService addressService;

    public Page<ManufacturerResponse> findAll(Pageable pageable) {
        return manufacturerRepository.findAll(pageable).map(ManufacturerResponse::of);
    }

    public ManufacturerResponse findById(Long id) {
        return manufacturerRepository.findById(id)
                .map(ManufacturerResponse::of)
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer with id " + id + " not found"));
    }

    public ManufacturerResponse save(Manufacturer manufacturer) {
        return ManufacturerResponse.of(manufacturerRepository.save(manufacturer));
    }

    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }

    public ManufacturerResponse update(Long id, Manufacturer manufacturer) {
        Manufacturer toBeUpdated = manufacturerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer with id " + id + " not found"));

        if (!manufacturer.getName().isBlank()) {
            toBeUpdated.setName(manufacturer.getName());
        }
        if (!manufacturer.getCnpj().isBlank()) {
            toBeUpdated.setCnpj(manufacturer.getCnpj());
        }
        if (!manufacturer.getEmail().isBlank()) {
            toBeUpdated.setEmail(manufacturer.getEmail());
        }
        if (!manufacturer.getContact().isBlank()) {
            toBeUpdated.setContact(manufacturer.getContact());
        }
        if (!manufacturer.getTelephone().isBlank()) {
            toBeUpdated.setTelephone(manufacturer.getTelephone());
        }
        if (manufacturer.getAddress() != null) {
            addressService.update(toBeUpdated.getId(), manufacturer.getAddress());
        }
        return ManufacturerResponse.of(manufacturerRepository.save(toBeUpdated));
    }
}