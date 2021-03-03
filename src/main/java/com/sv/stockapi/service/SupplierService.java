package com.sv.stockapi.service;

import com.sv.stockapi.error.exception.EntityNotFoundException;
import com.sv.stockapi.repository.SupplierRepository;
import com.sv.stockapi.repository.model.Supplier;
import com.sv.stockapi.resource.dto.response.SupplierResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final AddressService addressService;

    public List<SupplierResponse> findAll() {
        return supplierRepository.findAll().stream().map(SupplierResponse::of).collect(Collectors.toList());
    }

    public SupplierResponse findById(Long id) {
        return supplierRepository.findById(id)
                .map(SupplierResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Supplier with id %s not found", id)));
    }

    public SupplierResponse save(Supplier supplier) {
        return SupplierResponse.of(supplierRepository.save(supplier));
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    public SupplierResponse update(Long id, Supplier supplier) {
        Supplier toBeUpdated = supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Supplier with id %s not found", supplier.getId())));

        if (!supplier.getName().isEmpty()) {
            toBeUpdated.setName(supplier.getName());
        }
        if (!supplier.getCnpj().isEmpty()) {
            toBeUpdated.setCnpj(supplier.getCnpj());
        }
        if (!supplier.getEmail().isEmpty()) {
            toBeUpdated.setEmail(supplier.getEmail());
        }
        if (!supplier.getContact().isEmpty()) {
            toBeUpdated.setContact(supplier.getContact());
        }
        if (!supplier.getTelephone().isEmpty()) {
            toBeUpdated.setTelephone(supplier.getTelephone());
        }
        if (supplier.getAddress() != null) {
            addressService.update(toBeUpdated.getId(), supplier.getAddress());
        }
        return SupplierResponse.of(supplierRepository.save(toBeUpdated));
    }
}
