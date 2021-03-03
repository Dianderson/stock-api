package com.sv.stockapi.repository.model;

import com.sv.stockapi.resource.dto.request.supplier.CreateSupplierRequest;
import com.sv.stockapi.resource.dto.request.supplier.UpdateSupplierRequest;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @CNPJ
    @NotBlank
    @Column(unique = true)
    private String cnpj;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String contact;

    @NotBlank
    private String telephone;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public static Supplier of(CreateSupplierRequest request) {
        var supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setCnpj(request.getCnpj());
        supplier.setEmail(request.getEmail());
        supplier.setContact(request.getContact());
        supplier.setTelephone(request.getTelephone());
        supplier.setAddress(request.getAddress());
        return supplier;
    }

    public static Supplier of(UpdateSupplierRequest request) {
        var supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setCnpj(request.getCnpj());
        supplier.setEmail(request.getEmail());
        supplier.setContact(request.getContact());
        supplier.setTelephone(request.getTelephone());
        supplier.setAddress(request.getAddress());
        return supplier;
    }
}
