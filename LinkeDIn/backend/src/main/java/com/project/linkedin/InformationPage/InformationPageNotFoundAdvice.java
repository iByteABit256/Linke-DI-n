package com.project.linkedin.InformationPage;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InformationPageNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(InformationPageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(InformationPageNotFoundException ex) {
        return ex.getMessage();
    }
}
