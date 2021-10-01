package com.project.linkedin.ConnectionRequests;

public class ConnectionRequestsNotFoundException extends RuntimeException{
    ConnectionRequestsNotFoundException(Long id) {
        super("Could not find connection request" + id);
    }
}
