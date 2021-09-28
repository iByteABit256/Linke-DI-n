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
        //TODO: = instead of LIKE
        Query query = entityManager.createQuery("SELECT e FROM User e WHERE e.email LIKE ?1");
        query.setParameter(1, "%" + email + "%");
        List<User> list =  query.getResultList();

        if(list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public User getUserFromProf(Long id_prof){
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.id_user IN(" +
                " SELECT p.id_user FROM Proffessional p WHERE p.id_proffessional=?1)");
        query.setParameter(1, id_prof);
        List<User> list =  query.getResultList();

        if(list.size() == 0){
            return null;
        }

        return list.get(0);
    }

}

