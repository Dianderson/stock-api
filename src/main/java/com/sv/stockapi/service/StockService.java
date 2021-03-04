package com.sv.stockapi.service;

import com.sv.stockapi.repository.StockRepository;
import com.sv.stockapi.repository.model.Stock;
import com.sv.stockapi.resource.dto.response.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final SupplyService supplyService;
    private final SupplierService supplierService;

    public Page<StockResponse> findAll(Pageable pageable) {
        return stockRepository.findAll(pageable).map(StockResponse::of);
    }

    public StockResponse findById(Long id) {
        return stockRepository.findById(id)
                .map(StockResponse::of)
                .orElseThrow(() -> new EntityNotFoundException("Stock with id " + id + " not found"));
    }

    public StockResponse save(Stock stock) {
        return StockResponse.of(stockRepository.save(stock));
    }

    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    public StockResponse update(Long id, Stock stock) {
        Stock toBeUpdated = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock with id " + id + " not found"));

        if (stock.getSupply() != null) {
            supplyService.update(toBeUpdated.getId(), stock.getSupply());
        }
        if (stock.getSupplier() != null) {
            supplierService.update(toBeUpdated.getId(), stock.getSupplier());
        }
        if (!stock.getBatch().isBlank()) {
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
        Stock toBeUpdated = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock with id " + id + " not found"));
        toBeUpdated.setQuantity(toBeUpdated.getQuantity() + quantity);
        return StockResponse.of(stockRepository.save(toBeUpdated));
    }

    public StockResponse reduceQuantity(Long id, int quantity) {
        Stock toBeUpdated = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock with id " + id + " not found"));
        toBeUpdated.setQuantity(toBeUpdated.getQuantity() - quantity);
        return StockResponse.of(stockRepository.save(toBeUpdated));
    }
}