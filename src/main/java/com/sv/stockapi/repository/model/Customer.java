package com.sv.stockapi.repository.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotBlank
    private String password;

    private Credential credential;

}