package com.project.linkedin.JobOfferSeen;

import com.project.linkedin.JobOfferSeen.JobOfferSeenNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class JobOfferSeenNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(JobOfferSeenNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(JobOfferSeenNotFoundException ex) {
        return ex.getMessage();
    }

}
