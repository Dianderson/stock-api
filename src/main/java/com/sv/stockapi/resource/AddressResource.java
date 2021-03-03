package com.sv.stockapi.resource;

import com.sv.stockapi.repository.model.Address;
import com.sv.stockapi.resource.dto.request.address.CreateAddressRequest;
import com.sv.stockapi.resource.dto.request.address.UpdateAddressRequest;
import com.sv.stockapi.resource.dto.response.AddressResponse;
import com.sv.stockapi.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
@RequiredArgsConstructor
public class AddressResource {

    private final AddressService addressService;

    @GetMapping
    public List<AddressResponse> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse save(@RequestBody @Valid CreateAddressRequest request) {
        return addressService.save(Address.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse update(@PathVariable Long id, @RequestBody @Valid UpdateAddressRequest request) {
        return addressService.update(id, Address.of(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
