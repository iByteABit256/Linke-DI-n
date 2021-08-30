package com.project.linkedin.Post;



import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PostController {

    private final PostRepository repository;

    PostController(PostRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/posts")
    List<Post> all() {
        return repository.findAll();
    }

    @PostMapping("/posts")
    Post newPost(@RequestBody Post newPost) {
        return repository.save(newPost);
    }



    // Single item

    @GetMapping("/posts/{id}")
    Post one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }
}
