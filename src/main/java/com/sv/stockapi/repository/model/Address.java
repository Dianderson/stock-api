package com.sv.stockapi.repository.model;

import com.sv.stockapi.resource.dto.request.address.CreateAddressRequest;
import com.sv.stockapi.resource.dto.request.address.UpdateAddressRequest;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String street;

    @NotBlank
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

    public static Address of(UpdateAddressRequest request) {
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