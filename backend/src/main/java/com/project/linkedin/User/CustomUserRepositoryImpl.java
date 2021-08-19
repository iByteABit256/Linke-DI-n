package com.project.linkedin.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getNameLike(String firstName) {
        Query query = entityManager.createQuery("SELECT e FROM User e WHERE e.first_name LIKE ?1");
        query.setParameter(1, "%" + firstName + "%");
        return query.getResultList();

    }
    public User getEmailLike(String email) {
        Query query = entityManager.createQuery("SELECT e FROM User e WHERE e.email LIKE ?1");
        query.setParameter(1, "%" + email + "%");
        List<User> list =  query.getResultList();
        return list.get(0);
    }
}
