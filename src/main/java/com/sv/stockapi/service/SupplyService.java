package com.sv.stockapi.service;

import com.sv.stockapi.repository.SupplyRepository;
import com.sv.stockapi.repository.model.Supply;
import com.sv.stockapi.resource.dto.response.SupplyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final ManufacturerService manufacturerService;

    public Page<SupplyResponse> findAll(Pageable pageable) {
        return supplyRepository.findAll(pageable).map(SupplyResponse::of);
    }

    public SupplyResponse findById(Long id) {
        return supplyRepository.findById(id)
                .map(SupplyResponse::of)
                .orElseThrow(() -> new EntityNotFoundException("Supply with id " + id + " not found"));
    }

    public SupplyResponse save(Supply supply) {
        return SupplyResponse.of(supplyRepository.save(supply));
    }

    public void delete(Long id) {
        supplyRepository.deleteById(id);
    }

    public SupplyResponse update(Long id, Supply supply) {
        Supply toBeUpdated = supplyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supply with id " + id + " not found"));

        if (!supply.getName().isBlank()) {
            toBeUpdated.setName(supply.getName());
        }
        if (!supply.getDescription().isBlank()) {
            toBeUpdated.setDescription(supply.getDescription());
        }
        if (!supply.getAmount().isBlank()) {
            toBeUpdated.setAmount(supply.getAmount());
        }
        if (!supply.getUnit().isBlank()) {
            toBeUpdated.setUnit(supply.getUnit());
        }
        if (supply.getManufacturer() != null) {
            manufacturerService.update(toBeUpdated.getId(), supply.getManufacturer());
        }
        return SupplyResponse.of(supplyRepository.save(toBeUpdated));
    }
}
