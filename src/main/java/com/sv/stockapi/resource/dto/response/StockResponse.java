package com.sv.stockapi.resource.dto.response;

import com.sv.stockapi.repository.model.Stock;
import com.sv.stockapi.repository.model.Supplier;
import com.sv.stockapi.repository.model.Supply;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StockResponse {

    private Long id;
    private String supplyName;
    private String supplyDescription;
    private String supplyAmount;
    private String supplyUnit;
    private String supplyManufacturerName;
    private String supplierName;
    private String batch;
    private int quantity;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;

    public static StockResponse of(Stock stock) {
        var stockResponse = new StockResponse();
        stockResponse.setId(stock.getId());
        stockResponse.setSupplyName(stock.getSupply().getName());
        stockResponse.setSupplyDescription(stock.getSupply().getDescription());
        stockResponse.setSupplyAmount(stock.getSupply().getAmount());
        stockResponse.setSupplyUnit(stock.getSupply().getUnit());
        stockResponse.setSupplyManufacturerName(stock.getSupply().getManufacturer().getName());
        stockResponse.setSupplierName(stock.getSupplier().getName());
        stockResponse.setBatch(stock.getBatch());
        stockResponse.setQuantity(stock.getQuantity());
        stockResponse.setManufactureDate(stock.getManufactureDate());
        stockResponse.setExpirationDate(stock.getExpirationDate());
        return stockResponse;
    }
}
