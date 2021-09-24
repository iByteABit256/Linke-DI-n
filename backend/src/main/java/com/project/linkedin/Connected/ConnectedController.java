package com.project.linkedin.Connected;

import com.project.linkedin.User.User;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
class ConnectedController {

    private final ConnectedRepository repository;

    ConnectedController(ConnectedRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/connected")
    List<Connected> all() { return repository.findAll(); }

    @PostMapping("/connected")
    Connected newConnected(@RequestBody Connected newConnected) {
        return repository.save(newConnected);
    }

    @GetMapping("/connected/{id}")
    List<Long> one(@PathVariable Long id) {
        return repository.findConnected(id);
    }

    @GetMapping("/connected/full-{id}")
    List<User> fullone(@PathVariable Long id) {
        return repository.getConnectedUsers(id);
    }

}
