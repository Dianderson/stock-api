package com.sv.stockapi.resource;

import com.sv.stockapi.repository.model.Manufacturer;
import com.sv.stockapi.resource.dto.request.manufacturer.CreateManufacturerRequest;
import com.sv.stockapi.resource.dto.request.manufacturer.UpdateManufacturerRequest;
import com.sv.stockapi.resource.dto.response.ManufacturerResponse;
import com.sv.stockapi.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/manufacturer")
@RequiredArgsConstructor
public class ManufacturerResource {

    private final ManufacturerService manufacturerService;

    @GetMapping
    public Page<ManufacturerResponse> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        return manufacturerService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ManufacturerResponse findById(@PathVariable Long id) {
        return manufacturerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ManufacturerResponse save(@RequestBody @Valid CreateManufacturerRequest request) {
        return manufacturerService.save(Manufacturer.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManufacturerResponse update(@PathVariable Long id, @RequestBody @Valid UpdateManufacturerRequest request) {
        return manufacturerService.update(id, Manufacturer.of(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        manufacturerService.delete(id);
    }

}
