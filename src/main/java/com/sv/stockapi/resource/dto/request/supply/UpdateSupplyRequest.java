package com.sv.stockapi.resource.dto.request.supply;

import com.sv.stockapi.repository.model.Manufacturer;
import lombok.Data;

@Data
public class UpdateSupplyRequest {
    private String name;
    private String description;
    private String amount;
    private String unit;
    private Manufacturer manufacturer;
}
