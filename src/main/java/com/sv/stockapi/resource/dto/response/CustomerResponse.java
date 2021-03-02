package com.sv.stockapi.resource.dto.response;

import com.sv.stockapi.repository.model.Credential;
import com.sv.stockapi.repository.model.Customer;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Enum<Credential> credential;

    public static CustomerResponse of(Customer customer) {
        var customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setCpf(customer.getCpf());
        customerResponse.setCredential(customer.getCredential());
        return customerResponse;
    }
}