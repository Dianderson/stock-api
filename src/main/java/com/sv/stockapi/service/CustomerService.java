package com.sv.stockapi.service;

import com.sv.stockapi.error.exception.EntityNotFoundException;
import com.sv.stockapi.repository.CustomerRepository;
import com.sv.stockapi.repository.model.Customer;
import com.sv.stockapi.resource.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream().map(CustomerResponse::of).collect(Collectors.toList());
    }

    public CustomerResponse findById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Customer with id %s not found", id)));
    }

    public CustomerResponse save(Customer customer) {
        return CustomerResponse.of(customerRepository.save(customer));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerResponse update(Long id, Customer customer) {
        Customer toBeUpdated = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Customer with id %s not found", customer.getId())));

        if (!customer.getName().isEmpty()) {
            toBeUpdated.setName(customer.getName());
        }
        if (!customer.getCpf().isEmpty()) {
            toBeUpdated.setCpf(customer.getCpf());
        }
        if (!customer.getPassword().isEmpty()) {
            toBeUpdated.setPassword(customer.getPassword());
        }
        if (customer.getCredential() != null) {
            toBeUpdated.setCredential(customer.getCredential());
        }
        return CustomerResponse.of(customerRepository.save(toBeUpdated));
    }
}