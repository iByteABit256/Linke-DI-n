package com.project.linkedin.ConnectionRequests;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = false)
public class CustomConnectionRequestsRepositoryImpl implements CustomConnectionRequestsRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void accept(Long id1,Long id2){
        System.out.print("aaaaa");
        Query query1 = entityManager.createNativeQuery("DELETE  FROM connection_requests  WHERE (connection_requests.id_proffessional1=?2 AND connection_requests.id_proffessional2=?1)" );
        query1.setParameter(1, id1);
        query1.setParameter(2, id2);
        query1.executeUpdate();
        Query query2 = entityManager.createNativeQuery("INSERT INTO connected  VALUES (?1,?2)" );
        query2.setParameter(1, id1);
        query2.setParameter(2, id2);
        query2.executeUpdate();
    }

    @Override
    public void reject(Long id1,Long id2){
        Query query1 = entityManager.createNativeQuery("DELETE  FROM connection_requests  WHERE (connection_requests.id_proffessional1=?2 AND connection_requests.id_proffessional2=?1)" );
        query1.setParameter(1, id1);
        query1.setParameter(2, id2);
        query1.executeUpdate();

    }

    @Override
    public List<ConnectionRequests> getconnectionrequests(Long id){
        Query query1 = entityManager.createQuery("SELECT e FROM ConnectionRequests e WHERE e.id_proffessional2=?1" );
        query1.setParameter(1, id);
        return query1.getResultList();

    }





}
