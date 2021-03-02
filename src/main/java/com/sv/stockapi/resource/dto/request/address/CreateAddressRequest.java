package com.sv.stockapi.resource.dto.request.address;

import com.sv.stockapi.repository.model.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateAddressRequest extends AddressRequest {

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

    public static Address of(CreateAddressRequest request) {
        var address = new Address();
        address.setPostalCode(request.getPostalCode());
        address.setStreet(request.getStreet());
        address.setNumber(request.getNumber());
        address.setComplement(request.getComplement());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        return address;
    }
}
