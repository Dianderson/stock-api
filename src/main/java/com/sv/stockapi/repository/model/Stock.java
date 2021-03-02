package com.sv.stockapi.repository.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @OneToOne
    private Supply supply;

    @NotBlank
    @OneToMany
    private List<Supplier> supplier;

    @NotBlank
    private String batch;

    @NotNull
    private int quantity;

    @NotBlank
    private LocalDate manufactureDate;

    @NotBlank
    private LocalDate expirationDate;

}
