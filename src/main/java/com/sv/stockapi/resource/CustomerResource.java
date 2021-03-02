package com.sv.stockapi.resource;

import com.sv.stockapi.resource.dto.request.customer.CreateCustomerRequest;
import com.sv.stockapi.resource.dto.request.customer.UpdateCustomerRequest;
import com.sv.stockapi.resource.dto.response.CustomerResponse;
import com.sv.stockapi.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@RequestBody @Valid CreateCustomerRequest request) {
        return customerService.save(CreateCustomerRequest.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable Long id, @RequestBody @Valid UpdateCustomerRequest request) {
        return customerService.update(id, UpdateCustomerRequest.of(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
