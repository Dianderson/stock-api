package com.sv.stockapi.resource.dto.request.address;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateAddressRequest {

    @NotBlank
    private String postalCode;
    @NotBlank
    private String street;
    @NotNull
    private String number;
    private String complement;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
}
