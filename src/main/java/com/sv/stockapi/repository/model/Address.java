package com.sv.stockapi.repository.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String street;

    @NotNull
    private String number;

    private String complement;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String country;
}