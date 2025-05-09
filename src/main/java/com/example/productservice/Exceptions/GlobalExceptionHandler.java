package com.example.productservice.Exceptions;

import com.example.productservice.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ErrorDTO handleNullPointerException(NullPointerException npe) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus("Failure");
        errorDTO.setMessage("Null pointer exception occured");
        return errorDTO;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(Exception pnfe) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus("Failure");
        errorDTO.setMessage(pnfe.getMessage());
//        return errorDTO;
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
