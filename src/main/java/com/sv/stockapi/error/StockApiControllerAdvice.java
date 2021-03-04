package com.sv.stockapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class StockApiControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorHandlerModel> handleAnyException(Exception ex, HttpServletRequest request) {
        ErrorHandlerModel error = new ErrorHandlerModel();
        error.setTimestamp(Instant.now());
        error.setHttpStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorHandlerModel> handleEntityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        ErrorHandlerModel error = new ErrorHandlerModel();
        error.setTimestamp(Instant.now());
        error.setHttpStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
