package com.project.linkedin.InterestDeclaration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class InterestDeclarationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(InterestDeclarationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(InterestDeclarationNotFoundException ex) {
        return ex.getMessage();
    }

}
