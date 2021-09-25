package com.project.linkedin.JobOffer;



import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class JobOfferController {


    private final JobOfferRepository repository;

    JobOfferController(JobOfferRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/joboffers")
    List<JobOffer> all() {
        return repository.findAll();
    }

    @PostMapping("/joboffers")
    JobOffer newJobOffer(@RequestBody JobOffer newInterestDeclaration) {
        return repository.save(newInterestDeclaration);
    }
}
