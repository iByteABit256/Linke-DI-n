package com.project.linkedin.Message;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class CustomMessageRepositoryImpl implements CustomMessageRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Message> getMessages(Long id_disc){
        Query query = entityManager.createQuery("SELECT m FROM Message m WHERE m.id_discussion=?1");
        query.setParameter(1,id_disc);
        return query.getResultList();
    }

}
