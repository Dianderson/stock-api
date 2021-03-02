package com.sv.stockapi.resource.dto.request.customer;

import com.sv.stockapi.repository.model.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateCustomerRequest extends CustomerRequest {

    private String name;
    private String cpf;
    private String password;
    private String credential;

    public static Customer of(UpdateCustomerRequest request) {
        var customer = new Customer();
        customer.setName(request.getName());
        customer.setCpf(request.getCpf());
        customer.setPassword(request.getPassword());
        customer.setCredential(convertCredential(request.getCredential()));
        return customer;
    }
}
