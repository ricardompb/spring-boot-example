package com.krtec.econet.spring.config.errors;

import com.krtec.econet.dtos.global.ErrorDTO;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.method.MethodValidationException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND.toString()));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorDTO> handlerEntityExistsException(EntityExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(e.getMessage(), HttpStatus.CONFLICT.toString()));
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<ErrorDTO> validationExceptionHandler(MethodArgumentNotValidException ex) {}
}
