package com.project.linkedin.DiscussionIndex;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DiscussionIndexNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DiscussionIndexNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(DiscussionIndexNotFoundException ex) {
        return ex.getMessage();
    }
}
