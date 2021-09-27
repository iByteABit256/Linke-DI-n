package com.project.linkedin.ConnectionRequests;



import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ConnectionRequestController {

    private final ConnectionRequestRepository repository;

    ConnectionRequestController(ConnectionRequestRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/connectionrequests")
    List<ConnectionRequest> all() { return repository.findAll(); }

    @PostMapping("/connectionrequests")
    ConnectionRequest newConnectionRequest(@RequestBody ConnectionRequest newConnectionRequest) {
        return repository.save(newConnectionRequest);
    }
}
