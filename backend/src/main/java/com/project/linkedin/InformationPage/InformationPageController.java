package com.project.linkedin.InformationPage;


import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class InformationPageController {

    private final InformationPageRepository repository;

    InformationPageController(InformationPageRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/informationpages")
    List<InformationPage> all() {
        return repository.findAll();
    }

    @PostMapping("/informationpages")
    InformationPage newInformationPage(@RequestBody InformationPage newInformationPage) {
        return repository.save(newInformationPage);
    }



    // Single item

    @GetMapping("/informationpages/{id}")
    InformationPage one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new InformationPageNotFoundException(id));
    }
}
