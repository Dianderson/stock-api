package com.sv.stockapi.repository.model;

import com.sv.stockapi.resource.dto.request.customer.CreateCustomerRequest;
import com.sv.stockapi.resource.dto.request.customer.UpdateCustomerRequest;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

    public static Customer of(CreateCustomerRequest request) {
        var customer = new Customer();
        customer.setName(request.getName());
        customer.setCpf(request.getCpf());
        customer.setPassword(request.getPassword());
        customer.setRole(request.getRole());
        return customer;
    }

    public static Customer of(UpdateCustomerRequest request) {
        var customer = new Customer();
        customer.setName(request.getName());
        customer.setCpf(request.getCpf());
        customer.setPassword(request.getPassword());
        customer.setRole(request.getRole());
        return customer;
    }
}