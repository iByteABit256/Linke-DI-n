package com.project.linkedin.JobOfferApplication;



import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class JobOfferApplicationController {

    private final JobOfferApplicationRepository repository;

    JobOfferApplicationController(JobOfferApplicationRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/jobofferapplications")
    List<JobOfferApplication> all() {
        return repository.findAll();
    }

    @PostMapping("/jobofferapplications")
    JobOfferApplication newJobOffer(@RequestBody JobOfferApplication newJobOfferApplication) {
        return repository.save(newJobOfferApplication);
    }

    @GetMapping("/jobofferapplications/joboffer-{id_job_offer}")
    Long getApplicationsAmount(@PathVariable Long id_job_offer){
        return repository.getApplicationsAmount(id_job_offer);
    }

    @GetMapping("/jobofferapplications/recommendations-{id_prof}")
    List<JobOfferApplication> getRecommended(@PathVariable Long id_prof) { return repository.getRecommended(id_prof); }

}
