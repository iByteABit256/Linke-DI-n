package com.project.linkedin.Proffessional;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomProffessionalRepositoryImpl implements CustomProffessionalRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Proffessional> getNameLike(String firstName) {
//        Query query = entityManager.createQuery("SELECT e FROM Proffessional e WHERE e.first_name LIKE ?1");
//        query.setParameter(1, "%" + firstName + "%");
//        return query.getResultList();
        return null;

    }
    public List<Proffessional> getEmailLike(String email) {
//        Query query = entityManager.createQuery("SELECT e FROM Proffessional e WHERE e.email LIKE ?1");
//        query.setParameter(1, "%" + email + "%");
//        return query.getResultList();
        return null;

    }
}
