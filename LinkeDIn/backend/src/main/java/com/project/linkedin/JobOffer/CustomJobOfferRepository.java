package com.project.linkedin.JobOffer;

import java.util.List;

public interface CustomJobOfferRepository {
    List<JobOffer> getRecommended(Long id_prof, int n);
}
