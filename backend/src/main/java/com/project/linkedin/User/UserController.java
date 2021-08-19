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


    // @PutMapping("/users/{id}")
    // User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

    //     return repository.findById(id)
    //             .map(user -> {
    //                 user.setFirst_name(newUser.getFirst_name());
    //                 user.setLast_name(newUser.getLast_name());
    //                 return repository.save(user);
    //             })
    //             .orElseGet(() -> {
    //                 newUser.setId(id);
    //                 return repository.save(newUser);
    //             });
    // }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
