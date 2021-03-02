package com.sv.stockapi.resource.dto.request.manufacturer;

import com.sv.stockapi.repository.model.Address;
import com.sv.stockapi.repository.model.Manufacturer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateManufacturerRequest extends ManufacturerRequest {

    private String name;
    private String cnpj;
    private String email;
    private String contact;
    private String telephone;
    private Address address;

    public static Manufacturer of(UpdateManufacturerRequest request) {
        var manufacturer = new Manufacturer();
        manufacturer.setName(request.getName());
        manufacturer.setCnpj(request.getCnpj());
        manufacturer.setEmail(request.getEmail());
        manufacturer.setContact(request.getContact());
        manufacturer.setTelephone(request.getTelephone());
        manufacturer.setAddress(request.getAddress());
        return manufacturer;
    }

}
