package com.project.linkedin.Discussion;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class CustomDiscussionRepositoryImpl implements CustomDiscussionRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Discussion> getDiscussions(Long id_prof){
        Query query = entityManager.createQuery("SELECT d FROM Discussion d " +
                "WHERE d.id_proffessional1=?1 OR d.id_proffessional2=?1");
        query.setParameter(1,id_prof);
        return query.getResultList();
    }

}
