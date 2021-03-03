package com.sv.stockapi.resource.dto.request.supplier;

import com.sv.stockapi.repository.model.Address;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateSupplierRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String email;

    @NotBlank
    private String contact;

    @NotBlank
    private String telephone;

    @NotNull
    private Address address;
}