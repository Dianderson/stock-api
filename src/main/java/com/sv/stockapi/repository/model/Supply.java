package com.sv.stockapi.repository.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Entity
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Null
    private int amount;

    @NotBlank
    private String unit;

    @NotBlank
    @OneToOne
    private Manufacturer manufacturer;

}
