package com.sv.stockapi.resource.dto.request.manufacturer;

import com.sv.stockapi.repository.model.Address;
import com.sv.stockapi.repository.model.Manufacturer;
import com.sv.stockapi.resource.dto.request.address.CreateAddressRequest;
import com.sv.stockapi.resource.dto.response.AddressResponse;
import com.sv.stockapi.service.AddressService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateManufacturerRequest extends ManufacturerRequest {

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

    private Address address;

    public static Manufacturer of(CreateManufacturerRequest request) {
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
