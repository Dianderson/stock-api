package com.sv.stockapi.service;

import com.sv.stockapi.repository.CustomerRepository;
import com.sv.stockapi.repository.model.Customer;
import com.sv.stockapi.resource.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Page<CustomerResponse> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable).map(CustomerResponse::of);
    }

    public CustomerResponse findById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerResponse::of)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + id + " not found"));
    }

    public CustomerResponse save(Customer customer) {
        return CustomerResponse.of(customerRepository.save(customer));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerResponse update(Long id, Customer customer) {
        Customer toBeUpdated = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + id + " not found"));

        if (!customer.getName().isBlank()) {
            toBeUpdated.setName(customer.getName());
        }
        if (!customer.getCpf().isBlank()) {
            toBeUpdated.setCpf(customer.getCpf());
        }
        if (!customer.getPassword().isBlank()) {
            toBeUpdated.setPassword(customer.getPassword());
        }
        if (customer.getRole() != null) {
            toBeUpdated.setRole(customer.getRole());
        }
        return CustomerResponse.of(customerRepository.save(toBeUpdated));
    }
}