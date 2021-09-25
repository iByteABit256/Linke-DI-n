package com.project.linkedin.JobOffer;


import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> , CustomJobOfferRepository {
}
