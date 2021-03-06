package com.sv.stockapi.resource;

import com.sv.stockapi.repository.model.Supplier;
import com.sv.stockapi.resource.dto.request.supplier.CreateSupplierRequest;
import com.sv.stockapi.resource.dto.request.supplier.UpdateSupplierRequest;
import com.sv.stockapi.resource.dto.response.SupplierResponse;
import com.sv.stockapi.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/supplier")
@RequiredArgsConstructor
public class SupplierResource {

    private final SupplierService supplierService;

    @GetMapping
    public Page<SupplierResponse> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        return supplierService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public SupplierResponse findById(@PathVariable Long id) {
        return supplierService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierResponse save(@RequestBody @Valid CreateSupplierRequest request) {
        return supplierService.save(Supplier.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SupplierResponse update(@PathVariable Long id, @RequestBody @Valid UpdateSupplierRequest request) {
        return supplierService.update(id, Supplier.of(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        supplierService.delete(id);
    }
}
