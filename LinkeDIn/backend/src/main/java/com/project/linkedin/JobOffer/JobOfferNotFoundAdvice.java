package com.project.linkedin.JobOffer;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class JobOfferNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(JobOfferNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(JobOfferNotFoundException ex) {
        return ex.getMessage();
    }
}
