package com.project.linkedin.DiscussionIndex;




import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DiscussionIndexController {

    private final DiscussionIndexRepository repository;

    DiscussionIndexController(DiscussionIndexRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/discussionindexes")
    List<DiscussionIndex> all() { return repository.findAll(); }

    @PostMapping("/discussionindexes")
    DiscussionIndex newDiscussionIndex(@RequestBody DiscussionIndex newDiscussionIndex) {
        return repository.save(newDiscussionIndex);
    }
}
