package com.project.linkedin.JobOfferSeen;


import com.project.linkedin.JobOfferSeen.CustomJobOfferSeenRepository;
import com.project.linkedin.JobOfferSeen.JobOfferSeen;
import com.project.linkedin.JobOfferSeen.JobOfferSeenPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferSeenRepository  extends JpaRepository<JobOfferSeen, JobOfferSeenPK> , CustomJobOfferSeenRepository {
}
