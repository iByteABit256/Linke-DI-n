package com.project.linkedin.ConnectionRequests;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ConnectionRequestsNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ConnectionRequestsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(ConnectionRequestsNotFoundException ex) {
        return ex.getMessage();
    }
}
