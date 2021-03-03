package com.sv.stockapi.resource.dto.request.stock;

import com.sv.stockapi.repository.model.Supplier;
import com.sv.stockapi.repository.model.Supply;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateStockRequest {
    private Supply supply;
    private Supplier supplier;
    private String batch;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
}
