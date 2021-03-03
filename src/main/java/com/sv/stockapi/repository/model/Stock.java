package com.sv.stockapi.repository.model;

import com.sv.stockapi.resource.dto.request.stock.CreateStockRequest;
import com.sv.stockapi.resource.dto.request.stock.UpdateStockRequest;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Supply supply;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    @NotBlank
    private String batch;

    @NotNull
    private int quantity;

    @NotNull
    private LocalDate manufactureDate;

    @NotNull
    private LocalDate expirationDate;

    public static Stock of(CreateStockRequest request) {
        var stock = new Stock();
        stock.setSupply(request.getSupply());
        stock.setSupplier(request.getSupplier());
        stock.setBatch(request.getBatch());
        stock.setQuantity(request.getQuantity());
        stock.setManufactureDate(request.getManufactureDate());
        stock.setExpirationDate(request.getExpirationDate());
        return stock;
    }

    public static Stock of(UpdateStockRequest request) {
        var stock = new Stock();
        stock.setSupply(request.getSupply());
        stock.setSupplier(request.getSupplier());
        stock.setBatch(request.getBatch());
        stock.setManufactureDate(request.getManufactureDate());
        stock.setExpirationDate(request.getExpirationDate());
        return stock;
    }
}
