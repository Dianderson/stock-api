package com.sv.stockapi.resource.dto.request.supply;

import com.sv.stockapi.repository.model.Manufacturer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateSupplyRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private String amount;

    @NotBlank
    private String unit;

    @NotNull
    private Manufacturer manufacturer;
}