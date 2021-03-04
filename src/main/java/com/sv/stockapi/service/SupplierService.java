package com.sv.stockapi.service;

import com.sv.stockapi.repository.SupplierRepository;
import com.sv.stockapi.repository.model.Supplier;
import com.sv.stockapi.resource.dto.response.SupplierResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final AddressService addressService;

    public Page<SupplierResponse> findAll(Pageable pageable) {
        return supplierRepository.findAll(pageable).map(SupplierResponse::of);
    }

    public SupplierResponse findById(Long id) {
        return supplierRepository.findById(id)
                .map(SupplierResponse::of)
                .orElseThrow(() -> new EntityNotFoundException("Supplier with id " + id + " not found"));
    }

    public SupplierResponse findByCnpj(String cnpj) {
        return SupplierResponse.of(supplierRepository.findByCnpj(cnpj));
    }

    public SupplierResponse save(Supplier supplier) {
        return SupplierResponse.of(supplierRepository.save(supplier));
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    public SupplierResponse update(Long id, Supplier supplier) {
        Supplier toBeUpdated = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier with id " + id + " not found"));

        if (!supplier.getName().isBlank()) {
            toBeUpdated.setName(supplier.getName());
        }
        if (!supplier.getCnpj().isBlank()) {
            toBeUpdated.setCnpj(supplier.getCnpj());
        }
        if (!supplier.getEmail().isBlank()) {
            toBeUpdated.setEmail(supplier.getEmail());
        }
        if (!supplier.getContact().isBlank()) {
            toBeUpdated.setContact(supplier.getContact());
        }
        if (!supplier.getTelephone().isBlank()) {
            toBeUpdated.setTelephone(supplier.getTelephone());
        }
        if (supplier.getAddress() != null) {
            addressService.update(toBeUpdated.getId(), supplier.getAddress());
        }
        return SupplierResponse.of(supplierRepository.save(toBeUpdated));
    }
}
