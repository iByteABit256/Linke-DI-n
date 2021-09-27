package com.project.linkedin.JobOfferSeen;


import com.project.linkedin.JobOfferSeen.JobOfferSeen;
import com.project.linkedin.JobOfferSeen.JobOfferSeenNotFoundException;
import com.project.linkedin.JobOfferSeen.JobOfferSeenPK;
import com.project.linkedin.JobOfferSeen.JobOfferSeenRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class JobOfferSeenController {


    private final JobOfferSeenRepository repository;

    JobOfferSeenController(JobOfferSeenRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/jobofferseen")
    List<JobOfferSeen> all() {
        return repository.findAll();
    }

    @PostMapping("/jobofferseen")
    JobOfferSeen newJobOfferSeen(@RequestBody JobOfferSeen newJobOfferSeen) {
        return repository.save(newJobOfferSeen);
    }

    @GetMapping("/jobofferseen/{id}")
    JobOfferSeen one(@PathVariable JobOfferSeenPK id) {

        return repository.findById(id).orElseThrow(() -> new JobOfferSeenNotFoundException(id));
    }

}
