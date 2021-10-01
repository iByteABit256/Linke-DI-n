package com.project.linkedin.ConnectionRequests;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectionRequestsController {

    private final ConnectionRequestsRepository repository;

    ConnectionRequestsController(ConnectionRequestsRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/connectionrequests")
    List<ConnectionRequests> all() { return repository.findAll(); }

    @PostMapping("/connectionrequests")
    ConnectionRequests newConnectionRequest(@RequestBody ConnectionRequests newConnectionRequests) {
        return repository.save(newConnectionRequests);
    }


    @GetMapping("/connectionrequests/accept/{id1}/{id2}")
    void acceptConnectionRequest(@PathVariable Long id1,@PathVariable Long id2) {
        System.out.print("aaaaa");
        repository.accept(id1,id2);
    }

    @GetMapping("/connectionrequests/reject/{id1}/{id2}")
    void rejectConnectionRequest(@PathVariable Long id1,@PathVariable Long id2) {
        repository.reject(id1,id2);
    }

    @GetMapping("/connectionrequests/{id}")
    List<ConnectionRequests> findConnectionRequests(@PathVariable Long id) {
        return repository.getconnectionrequests(id);
    }




}
