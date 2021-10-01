package com.project.linkedin.Message;

public class MessageNotFoundException extends RuntimeException{
    MessageNotFoundException(Long id) {
        super("Could not find discussion" + id);
    }
}
