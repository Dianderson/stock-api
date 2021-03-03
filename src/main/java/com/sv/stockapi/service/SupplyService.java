package com.sv.stockapi.service;

import com.sv.stockapi.error.exception.EntityNotFoundException;
import com.sv.stockapi.repository.SupplyRepository;
import com.sv.stockapi.repository.model.Supply;
import com.sv.stockapi.resource.dto.response.SupplyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final ManufacturerService manufacturerService;

    public List<SupplyResponse> findAll() {
        return supplyRepository.findAll().stream().map(SupplyResponse::of).collect(Collectors.toList());
    }

    public SupplyResponse findById(Long id) {
        return supplyRepository.findById(id)
                .map(SupplyResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Supply with id %s not found", id)));
    }

    public SupplyResponse save(Supply supply) {
        return SupplyResponse.of(supplyRepository.save(supply));
    }

    public void delete(Long id) {
        supplyRepository.deleteById(id);
    }

    public SupplyResponse update(Long id, Supply supply) {
        Supply toBeUpdated = supplyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Supply with id %s not found", supply.getId())));

        if (!supply.getName().isEmpty()) {
            toBeUpdated.setName(supply.getName());
        }
        if (!supply.getDescription().isEmpty()) {
            toBeUpdated.setDescription(supply.getDescription());
        }
        if (!supply.getAmount().isEmpty()) {
            toBeUpdated.setAmount(supply.getAmount());
        }
        if (!supply.getUnit().isEmpty()) {
            toBeUpdated.setUnit(supply.getUnit());
        }
        if (supply.getManufacturer() != null) {
            manufacturerService.update(toBeUpdated.getId(), supply.getManufacturer());
        }
        return SupplyResponse.of(supplyRepository.save(toBeUpdated));
    }
}
