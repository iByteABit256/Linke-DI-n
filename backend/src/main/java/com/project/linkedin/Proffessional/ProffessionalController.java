package com.project.linkedin.Proffessional;


import com.project.linkedin.User.User;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.logging.Logger;

@RestController
class ProffessionalController {

    private final ProffessionalRepository repository;

    ProffessionalController(ProffessionalRepository repository) {
        this.repository = repository;
    }


    // Aggregate root

    @GetMapping("/proffessionals")
    List<Proffessional> all() {
        return repository.findAll();
    }

    @PostMapping("/proffessionals")
    Proffessional newProffessional(@RequestBody Proffessional newProffessional) {
        System.out.println(newProffessional);
        return repository.save(newProffessional);
    }

    // Single item

    @GetMapping("/proffessionals/{id}")
    Proffessional one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProffessionalNotFoundException(id));
    }

    // Get by user id

    @GetMapping("/proffessionals/user-{id}")
    Proffessional getByUserID(@PathVariable Long id) {
        return repository.getProffessionalByUserID(id);
    }

    @GetMapping("/proffessionals/search-{name}")
    List<User> like(@PathVariable String name) {

        return repository.getNameLike(name);
    }

}
