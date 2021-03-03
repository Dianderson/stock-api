package com.sv.stockapi.repository.model;

import com.sv.stockapi.resource.dto.request.supply.CreateSupplyRequest;
import com.sv.stockapi.resource.dto.request.supply.UpdateSupplyRequest;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private String amount;

    @NotBlank
    private String unit;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Manufacturer manufacturer;

    public static Supply of(CreateSupplyRequest request) {
        var supply = new Supply();
        supply.setName(supply.getName());
        supply.setDescription(request.getDescription());
        supply.setAmount(request.getAmount());
        supply.setUnit(request.getUnit());
        supply.setManufacturer(request.getManufacturer());
        return supply;
    }

    public static Supply of(UpdateSupplyRequest request) {
        var supply = new Supply();
        supply.setName(supply.getName());
        supply.setDescription(request.getDescription());
        supply.setAmount(request.getAmount());
        supply.setUnit(request.getUnit());
        supply.setManufacturer(request.getManufacturer());
        return supply;
    }
}
