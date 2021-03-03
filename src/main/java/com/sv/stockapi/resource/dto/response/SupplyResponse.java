package com.sv.stockapi.resource.dto.response;

import com.sv.stockapi.repository.model.Manufacturer;
import com.sv.stockapi.repository.model.Supply;
import lombok.Data;

@Data
public class SupplyResponse {

    private Long id;
    private String name;
    private String description;
    private String amount;
    private String unit;
    private Manufacturer manufacturer;

    public static SupplyResponse of(Supply supply) {
        var supplyResponse = new SupplyResponse();
        supplyResponse.setId(supply.getId());
        supplyResponse.setName(supply.getName());
        supplyResponse.setDescription(supply.getDescription());
        supplyResponse.setAmount(supply.getAmount());
        supplyResponse.setUnit(supply.getUnit());
        supplyResponse.setManufacturer(supply.getManufacturer());
        return supplyResponse;
    }
}
