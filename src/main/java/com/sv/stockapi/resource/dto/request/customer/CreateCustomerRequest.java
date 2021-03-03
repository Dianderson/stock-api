package com.sv.stockapi.resource.dto.request.customer;

import com.sv.stockapi.repository.model.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateCustomerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String password;

    @NotNull
    private Role role;
}
