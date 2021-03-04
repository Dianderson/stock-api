package com.sv.stockapi.resource;

import com.sv.stockapi.repository.model.Stock;
import com.sv.stockapi.resource.dto.request.stock.ChangeStockRequest;
import com.sv.stockapi.resource.dto.request.stock.CreateStockRequest;
import com.sv.stockapi.resource.dto.request.stock.UpdateStockRequest;
import com.sv.stockapi.resource.dto.response.StockResponse;
import com.sv.stockapi.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/stock")
@RequiredArgsConstructor
public class StockResource {

    private final StockService stockService;

    @GetMapping
    public Page<StockResponse> findAll(@PageableDefault(sort = "supplyName") Pageable pageable) {
        return stockService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public StockResponse findById(@PathVariable Long id) {
        return stockService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockResponse save(@RequestBody @Valid CreateStockRequest request) {
        return stockService.save(Stock.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StockResponse update(@PathVariable Long id, @RequestBody @Valid UpdateStockRequest request) {
        return stockService.update(id, Stock.of(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        stockService.delete(id);
    }

    @PutMapping("/add/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StockResponse addQuantity(@PathVariable Long id, @RequestBody @Valid ChangeStockRequest request) {
        return stockService.addQuantity(id, request.getQuantity());
    }

    @PutMapping("/reduce/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StockResponse reduceQuantity(@PathVariable Long id, @RequestBody @Valid ChangeStockRequest request) {
        return stockService.reduceQuantity(id, request.getQuantity());
    }
}
