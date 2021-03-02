package com.sv.stockapi.resource.dto.response;

import com.sv.stockapi.repository.model.Address;
import com.sv.stockapi.repository.model.Manufacturer;
import lombok.Data;

@Data
public class ManufacturerResponse {
    private String name;
    private String cnpj;
    private String email;
    private String contact;
    private String telephone;
    private Address address;

    public static ManufacturerResponse of(Manufacturer manufacturer) {
        var manufacturerResponse = new ManufacturerResponse();
        manufacturerResponse.setName(manufacturer.getName());
        manufacturerResponse.setCnpj(manufacturer.getCnpj());
        manufacturerResponse.setEmail(manufacturer.getEmail());
        manufacturerResponse.setContact(manufacturer.getContact());
        manufacturerResponse.setTelephone(manufacturer.getTelephone());
        manufacturerResponse.setAddress(manufacturer.getAddress());
        return manufacturerResponse;
    }
}
