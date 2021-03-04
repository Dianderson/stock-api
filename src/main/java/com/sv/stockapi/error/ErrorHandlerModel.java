package com.sv.stockapi.error;

import lombok.Data;

import java.time.Instant;

@Data
public class ErrorHandlerModel {
    private Instant timestamp;
    private int httpStatus;
    private String error;
    private String message;
    private String path;
}
