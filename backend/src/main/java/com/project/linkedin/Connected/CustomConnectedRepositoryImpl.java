package com.project.linkedin.Connected;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomConnectedRepositoryImpl implements CustomConnectedRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Long> findConnected(Long id) {
        Query query1 = entityManager.createQuery("SELECT e.proffessional_id1 FROM Connected e WHERE e.proffessional_id2 = ?1" );
        query1.setParameter(1, id);
        Query query2 = entityManager.createQuery("SELECT e.proffessional_id2 FROM Connected e WHERE e.proffessional_id1 = ?1" );
        query2.setParameter(1, id);
        List list1 = query1.getResultList();
        List list2 =  query2.getResultList();
        list1.addAll(list2);
        return list1;

    }

}
