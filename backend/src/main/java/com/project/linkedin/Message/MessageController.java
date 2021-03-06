package com.project.linkedin.Message;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/messages")
    List<Message> all() { return repository.findAll(); }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        return repository.save(newMessage);
    }

    @GetMapping("/messages/disc-{id_disc}")
    List<Message> getMessages(@PathVariable Long id_disc) {
        return repository.getMessages(id_disc);
    }

}
