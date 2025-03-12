package io.github.ferdynandariza.websocketchat.controller;

import io.github.ferdynandariza.websocketchat.model.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<GenericResponse<Object>> handleUsernameNotFoundException(UsernameNotFoundException e) {
        GenericResponse<Object> response =new GenericResponse<>();
        response.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
