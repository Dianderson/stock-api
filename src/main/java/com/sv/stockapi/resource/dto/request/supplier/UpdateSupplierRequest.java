package com.sv.stockapi.resource.dto.request.supplier;

import com.sv.stockapi.repository.model.Address;
import lombok.Data;

@Data
public class UpdateSupplierRequest {
    private String name;
    private String cnpj;
    private String email;
    private String contact;
    private String telephone;
    private Address address;
}
