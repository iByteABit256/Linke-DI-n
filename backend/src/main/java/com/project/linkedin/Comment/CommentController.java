package com.project.linkedin.Comment;

import com.project.linkedin.User.User;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
class CommentController {

    private final CommentRepository repository;

    CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/comments")
    List<Comment> all() { return repository.findAll(); }

    @PostMapping("/comments")
    Comment newComment(@RequestBody Comment newComment) {
        return repository.save(newComment);
    }

    @GetMapping("/comments/{postid}/{proffid}")
    Comment one(@PathVariable Long postid,@PathVariable Long proffid) {
        return repository.findComment(postid,proffid);
    }

    @GetMapping("/comments/{postid}")
    List<Comment> getComments(@PathVariable Long postid) {
        return repository.getPostComments(postid);
    }

    @GetMapping("/comments/users-{postid}")
    List<User> getUsersFromComments(@PathVariable Long postid) {
        return repository.getUsersWhoCommented(postid);
    }
}
