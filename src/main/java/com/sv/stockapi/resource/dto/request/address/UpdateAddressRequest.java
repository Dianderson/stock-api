package com.sv.stockapi.resource.dto.request.address;

import lombok.Data;

@Data
public class UpdateAddressRequest {
    private String postalCode;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;
}
