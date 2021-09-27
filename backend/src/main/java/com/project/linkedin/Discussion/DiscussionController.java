package com.project.linkedin.Discussion;



import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DiscussionController {

    private final DiscussionRepository repository;

    DiscussionController(DiscussionRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/discussions")
    List<Discussion> all() { return repository.findAll(); }

    @PostMapping("/discussions")
    Discussion newDiscussion(@RequestBody Discussion newDiscussion) {
        return repository.save(newDiscussion);
    }

}
