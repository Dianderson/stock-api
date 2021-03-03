package com.sv.stockapi.resource.dto.response;

import com.sv.stockapi.repository.model.Address;
import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String postalCode;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;

    public static AddressResponse of(Address address) {
        var addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setPostalCode(address.getPostalCode());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setNumber(address.getNumber());
        addressResponse.setComplement(address.getComplement());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setCountry(address.getCountry());
        return addressResponse;
    }
}
