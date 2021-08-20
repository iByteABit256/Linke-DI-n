package com.project.linkedin.Connected;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ConnectedNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ConnectedNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(ConnectedNotFoundException ex) {
        return ex.getMessage();
    }
}