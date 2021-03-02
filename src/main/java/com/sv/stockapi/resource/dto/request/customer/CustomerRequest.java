package com.sv.stockapi.resource.dto.request.customer;

import com.sv.stockapi.repository.model.Credential;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequest {

    public static Credential convertCredential(String credential) {
        switch (credential) {
            case "master":
                return Credential.MASTER;
            case "user":
                return Credential.USER;
            case "viewer":
                return Credential.VIEWER;
            default:
                return null;
        }
    }
}