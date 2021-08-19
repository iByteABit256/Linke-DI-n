package com.project.linkedin.Proffessional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ProffessionalNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProffessionalNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(ProffessionalNotFoundException ex) {
        return ex.getMessage();
    }
}


