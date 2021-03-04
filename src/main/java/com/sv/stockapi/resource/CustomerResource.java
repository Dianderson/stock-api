package com.sv.stockapi.resource;

import com.sv.stockapi.repository.model.Customer;
import com.sv.stockapi.resource.dto.request.customer.CreateCustomerRequest;
import com.sv.stockapi.resource.dto.request.customer.UpdateCustomerRequest;
import com.sv.stockapi.resource.dto.response.CustomerResponse;
import com.sv.stockapi.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping
    public Page<CustomerResponse> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@RequestBody @Valid CreateCustomerRequest request) {
        return customerService.save(Customer.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable Long id, @RequestBody @Valid UpdateCustomerRequest request) {
        return customerService.update(id, Customer.of(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
