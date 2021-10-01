package com.project.linkedin.JobOffer;



import com.project.linkedin.JobOfferSeen.JobOfferSeen;
import com.project.linkedin.JobOfferSeen.JobOfferSeenPK;
import com.project.linkedin.JobOfferSeen.JobOfferSeenRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class JobOfferController {


    private final JobOfferRepository repository;
    private final JobOfferSeenRepository repository2;

    JobOfferController(JobOfferRepository repository, JobOfferSeenRepository repository2) {
        this.repository = repository;
        this.repository2 = repository2;
    }

    // Aggregate root

    @GetMapping("/joboffers/prof-{id_prof}")
    List<JobOffer> all(@PathVariable Long id_prof) {
        List<JobOffer> l = repository.findAll();
        for(JobOffer jOffer : l){
            JobOfferSeen key = new JobOfferSeen(id_prof, jOffer.getId_job_offer());
            repository2.save(key);
        }
        return l;
    }

    @GetMapping("/joboffers/nosave")
    List<JobOffer> nosave() {
        return repository.findAll();
    }

    @PostMapping("/joboffers")
    JobOffer newJobOffer(@RequestBody JobOffer newInterestDeclaration) {
        return repository.save(newInterestDeclaration);
    }

    @GetMapping("/joboffers/recommendations-{id_prof}")
    List<JobOffer> getRecommended(@PathVariable Long id_prof){
       return repository.getRecommended(id_prof, 5);
    }

}
