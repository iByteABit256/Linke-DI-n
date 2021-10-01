package com.project.linkedin.JobOfferApplication;


import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferApplicationRepository extends JpaRepository<JobOfferApplication, JobOfferApplicationPK> , CustomJobOfferApplicationRepository {
}
