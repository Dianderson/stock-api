package com.sv.stockapi.resource.dto.request.stock;

import com.sv.stockapi.repository.model.Supplier;
import com.sv.stockapi.repository.model.Supply;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CreateStockRequest {
    @NotNull
    private Supply supply;

    @NotNull
    private Supplier supplier;

    @NotBlank
    private String batch;

    @NotNull
    private int quantity;

    @NotNull
    private LocalDate manufactureDate;

    @NotNull
    private LocalDate expirationDate;
}
