package com.leonp967.winestore.exception.handler;

import com.leonp967.winestore.exception.ClientsQueryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ClientsQueryExceptionHandler {

    @ExceptionHandler(value = { ClientsQueryException.class })
    protected ResponseEntity<Object> handle(ClientsQueryException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
