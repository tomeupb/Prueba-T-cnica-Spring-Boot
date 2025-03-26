package com.actividad.demo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalNaveExcepciones {


     @ExceptionHandler(NaveExcepciones.class)
    public ResponseEntity<String> handleNaveNotFoundException(NaveExcepciones ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

  
}
