package com.sv.stockapi.service;

import com.sv.stockapi.error.exception.EntityNotFoundException;
import com.sv.stockapi.repository.StockRepository;
import com.sv.stockapi.repository.model.Stock;
import com.sv.stockapi.resource.dto.response.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final SupplyService supplyService;
    private final SupplierService supplierService;

    public List<StockResponse> findAll() {
        return stockRepository.findAll().stream().map(StockResponse::of).collect(Collectors.toList());
    }

    public StockResponse findById(Long id) {
        return stockRepository.findById(id)
                .map(StockResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Stock with id %s not found", id)));
    }

    public StockResponse save(Stock stock) {
        return StockResponse.of(stockRepository.save(stock));
    }

    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    public StockResponse update(Long id, Stock stock) {
        Stock toBeUpdated = stockRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Stock with id %s not found", id)));

        if (stock.getSupply() != null) {
            supplyService.update(toBeUpdated.getId(), stock.getSupply());
        }
        if (stock.getSupplier() != null) {
            supplierService.update(toBeUpdated.getId(), stock.getSupplier());
        }
        if (!stock.getBatch().isEmpty()) {
            toBeUpdated.setBatch(stock.getBatch());
        }
        if (stock.getManufactureDate() != null) {
            toBeUpdated.setManufactureDate(stock.getManufactureDate());
        }
        if (stock.getExpirationDate() != null) {
            toBeUpdated.setExpirationDate(stock.getExpirationDate());
        }
        return StockResponse.of(stockRepository.save(toBeUpdated));
    }

    public StockResponse addQuantity(Long id, int quantity) {
        Stock toBeUpdated = stockRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Stock with id %s not found", id)));
        toBeUpdated.setQuantity(toBeUpdated.getQuantity() + quantity);
        return StockResponse.of(stockRepository.save(toBeUpdated));
    }

    public StockResponse reduceQuantity(Long id, int quantity) {
        Stock toBeUpdated = stockRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Stock with id %s not found", id)));
        toBeUpdated.setQuantity(toBeUpdated.getQuantity() - quantity);
        return StockResponse.of(stockRepository.save(toBeUpdated));
    }
}