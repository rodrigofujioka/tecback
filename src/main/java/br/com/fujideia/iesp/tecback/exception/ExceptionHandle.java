package br.com.fujideia.iesp.tecback.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FujiException>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<FujiException> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new FujiException(error.getField(), error.getDefaultMessage()));
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
