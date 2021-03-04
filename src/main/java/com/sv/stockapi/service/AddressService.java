package com.sv.stockapi.service;

import com.sv.stockapi.repository.AddressRepository;
import com.sv.stockapi.repository.model.Address;
import com.sv.stockapi.resource.dto.response.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Page<AddressResponse> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable).map(AddressResponse::of);
    }

    public AddressResponse findById(Long id) {
        return addressRepository.findById(id)
                .map(AddressResponse::of)
                .orElseThrow(() -> new EntityNotFoundException("Address with id " + id + " not found"));
    }

    public AddressResponse save(Address address) {
        return AddressResponse.of(addressRepository.save(address));
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    public AddressResponse update(Long id, Address address) {
        Address toBeUpdated = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address with id " + id + " not found"));

        if (!address.getPostalCode().isBlank()) {
            toBeUpdated.setPostalCode(address.getPostalCode());
        }
        if (!address.getStreet().isBlank()) {
            toBeUpdated.setStreet(address.getStreet());
        }
        if (!address.getNumber().isBlank()) {
            toBeUpdated.setNumber(address.getNumber());
        }
        if (!address.getComplement().isBlank()) {
            toBeUpdated.setComplement(address.getComplement());
        }
        if (!address.getCity().isBlank()) {
            toBeUpdated.setCity(address.getCity());
        }
        if (!address.getState().isBlank()) {
            toBeUpdated.setState(address.getState());
        }
        if (!address.getCountry().isBlank()) {
            toBeUpdated.setCountry(address.getCountry());
        }
        return AddressResponse.of(addressRepository.save(toBeUpdated));
    }
}
