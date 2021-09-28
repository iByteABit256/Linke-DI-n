package com.project.linkedin.Discussion;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/discussions/sender-{id_prof}")
    List<Discussion> getDiscussions(@PathVariable Long id_prof) {
        return repository.getDiscussions(id_prof);
    }

}
