package com.project.linkedin.Connected;

public class ConnectedNotFoundException extends RuntimeException  {

    ConnectedNotFoundException(Long id) {
        super("Could not find connection" + id);
    }

}
