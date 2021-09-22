package com.project.linkedin.Proffessional;

import com.project.linkedin.User.User;
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
    public List<User> getNameLike(String firstName) {
        Query query = entityManager.createQuery(" SELECT u FROM User u WHERE (u.first_name LIKE ?1 OR u.last_name LIKE ?1)");
        query.setParameter(1, "%" + firstName + "%");
        return query.getResultList();
    }
    public List<Proffessional> getEmailLike(String email) {
//        Query query = entityManager.createQuery("SELECT e FROM Proffessional e WHERE e.email LIKE ?1");
//        query.setParameter(1, "%" + email + "%");
//        return query.getResultList();
        return null;
    }

    public Proffessional getProffessionalByUserID(Long ID){
        Query query = entityManager.createQuery("SELECT p FROM Proffessional p WHERE p.id_user = ?1");
        query.setParameter(1, ID);
        List<Proffessional> list = query.getResultList();

        if(list.size() == 0){
            return null;
        }

        return list.get(0);
    }
}
