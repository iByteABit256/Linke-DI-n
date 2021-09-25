package com.project.linkedin.JobOfferApplication;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class JobOfferApplicationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(JobOfferApplicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(JobOfferApplicationNotFoundException ex) {
        return ex.getMessage();
    }
}
