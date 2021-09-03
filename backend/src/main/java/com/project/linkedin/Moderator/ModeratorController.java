package com.project.linkedin.Moderator;


import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class ModeratorController {


    private final ModeratorRepository repository;

    ModeratorController(ModeratorRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/moderators")
    List<Moderator> all() {
        return repository.findAll();
    }

    @PostMapping("/moderators")
    Moderator newModerator(@RequestBody Moderator newModerator) {
        return repository.save(newModerator);
    }



    // Single item

    @GetMapping("/moderators/{id}")
    Moderator one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ModeratorNotFoundException(id));
    }
}
