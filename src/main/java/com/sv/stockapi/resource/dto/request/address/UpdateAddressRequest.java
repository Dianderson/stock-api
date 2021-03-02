package com.sv.stockapi.resource.dto.request.address;

import com.sv.stockapi.repository.model.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateAddressRequest extends AddressRequest {
    private String postalCode;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;

    public static Address of(UpdateAddressRequest request) {
        var address = new Address();
        address.setPostalCode(request.getPostalCode());
        address.setStreet(request.getStreet());
        address.setNumber(request.getNumber());
        address.setComplement(request.complement);
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        return address;
    }
}
