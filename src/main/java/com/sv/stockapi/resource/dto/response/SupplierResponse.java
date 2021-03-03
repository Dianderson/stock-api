package com.sv.stockapi.resource.dto.response;

import com.sv.stockapi.repository.model.Address;
import com.sv.stockapi.repository.model.Supplier;
import lombok.Data;

@Data
public class SupplierResponse {

    private Long id;
    private String name;
    private String cnpj;
    private String email;
    private String contact;
    private String telephone;
    private Address address;

    public static SupplierResponse of(Supplier supplier) {
        var supplierResponse = new SupplierResponse();
        supplierResponse.setId(supplier.getId());
        supplierResponse.setName(supplier.getName());
        supplierResponse.setCnpj(supplier.getCnpj());
        supplierResponse.setEmail(supplier.getEmail());
        supplierResponse.setContact(supplier.getContact());
        supplierResponse.setTelephone(supplier.getTelephone());
        supplierResponse.setAddress(supplier.getAddress());
        return supplierResponse;
    }

}
