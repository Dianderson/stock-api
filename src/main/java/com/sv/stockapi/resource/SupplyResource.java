package com.sv.stockapi.resource;

import com.sv.stockapi.repository.model.Supply;
import com.sv.stockapi.resource.dto.request.supply.CreateSupplyRequest;
import com.sv.stockapi.resource.dto.request.supply.UpdateSupplyRequest;
import com.sv.stockapi.resource.dto.response.SupplyResponse;
import com.sv.stockapi.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/supply")
@RequiredArgsConstructor
public class SupplyResource {

    private final SupplyService supplyService;

    @GetMapping
    public Page<SupplyResponse> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        return supplyService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public SupplyResponse findById(@PathVariable Long id) {
        return supplyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplyResponse save(@RequestBody @Valid CreateSupplyRequest request) {
        return supplyService.save(Supply.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SupplyResponse update(@PathVariable Long id, @RequestBody @Valid UpdateSupplyRequest request) {
        return supplyService.update(id, Supply.of(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        supplyService.delete(id);
    }
}
