package com.sv.stockapi.resource.dto.response;

import com.sv.stockapi.repository.model.Stock;
import com.sv.stockapi.repository.model.Supplier;
import com.sv.stockapi.repository.model.Supply;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StockResponse {

    private Long id;
    private Supply supply;
    private Supplier supplier;
    private String batch;
    private int quantity;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;

    public static StockResponse of(Stock stock) {
        var stockResponse = new StockResponse();
        stockResponse.setId(stock.getId());
        stockResponse.setSupply(stock.getSupply());
        stockResponse.setSupplier(stock.getSupplier());
        stockResponse.setBatch(stock.getBatch());
        stockResponse.setQuantity(stock.getQuantity());
        stockResponse.setManufactureDate(stock.getManufactureDate());
        stockResponse.setExpirationDate(stock.getExpirationDate());
        return stockResponse;
    }
}
