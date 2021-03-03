package com.sv.stockapi.resource.dto.request.customer;

import com.sv.stockapi.repository.model.Role;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private String name;
    private String cpf;
    private String password;
    private Role role;
}
