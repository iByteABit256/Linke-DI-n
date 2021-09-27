package com.project.linkedin.JobOfferApplication;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomJobOfferApplicationRepositoryImpl implements CustomJobOfferApplicationRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Long getApplicationsAmount(Long id_job_offer){
        Query q = entityManager.createQuery("SELECT COUNT(i.id_proffessional) FROM JobOffer i WHERE i.id_job_offer = ?1" );
        q.setParameter(1, id_job_offer);
        List res =  q.getResultList();
        return (Long) res.get(0);

    }

}
