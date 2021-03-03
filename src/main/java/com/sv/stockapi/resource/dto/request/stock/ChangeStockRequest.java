package com.sv.stockapi.resource.dto.request.stock;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChangeStockRequest {

    @NotNull
    private int quantity;
}
