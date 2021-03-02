package com.sv.stockapi.repository.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @CNPJ
    @NotBlank
    @Column(unique = true)
    private String cnpj;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String contact;

    @NotBlank
    private String telephone;

    @NotBlank
    @OneToOne
    private Address address;

}
