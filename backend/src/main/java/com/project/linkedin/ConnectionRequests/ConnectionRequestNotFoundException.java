package com.project.linkedin.ConnectionRequests;

public class ConnectionRequestNotFoundException extends RuntimeException{
    ConnectionRequestNotFoundException(Long id) {
        super("Could not find connection request" + id);
    }
}
