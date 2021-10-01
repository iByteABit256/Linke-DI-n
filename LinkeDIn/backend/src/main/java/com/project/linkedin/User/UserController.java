package com.project.linkedin.User;

import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }


    // login get
    @GetMapping("/users/authentication-{email}")
    User loginUser(@PathVariable String email) {
        return repository.getEmailLike(email);
    }


    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/userslike/{name}")
    List<User> like(@PathVariable String name) {

        return repository.getNameLike(name);
    }

    @GetMapping("/users/prof-{id_prof}")
    User getUserFromProf(@PathVariable Long id_prof) {
        return repository.getUserFromProf(id_prof);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
