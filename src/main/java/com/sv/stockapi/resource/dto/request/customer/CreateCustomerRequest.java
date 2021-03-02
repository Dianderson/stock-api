package com.sv.stockapi.resource.dto.request.customer;

import com.sv.stockapi.repository.model.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateCustomerRequest extends CustomerRequest {

    @NotBlank
    private String name;

    @CPF
    @NotBlank
    private String cpf;

    @NotBlank
    private String password;

    @NotBlank
    private String credential;

    public static Customer of(CreateCustomerRequest request) {
        var customer = new Customer();
        customer.setName(request.getName());
        customer.setCpf(request.getCpf());
        customer.setPassword(request.getPassword());
        if (convertCredential(request.getCredential()) == null) {
            throw new EntityNotFoundException("Credential not found, please insert : 'master', 'user' or 'viewer'");
        }
        customer.setCredential(convertCredential(request.getCredential()));
        return customer;
    }
}
