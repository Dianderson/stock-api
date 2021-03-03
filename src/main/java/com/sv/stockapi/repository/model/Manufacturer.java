package com.sv.stockapi.repository.model;

import com.sv.stockapi.resource.dto.request.manufacturer.CreateManufacturerRequest;
import com.sv.stockapi.resource.dto.request.manufacturer.UpdateManufacturerRequest;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Manufacturer {

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
