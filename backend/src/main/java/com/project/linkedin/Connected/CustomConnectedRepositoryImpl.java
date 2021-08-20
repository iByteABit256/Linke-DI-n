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
        Query query = entityManager.createNativeQuery("SELECT e.Proffessional_idProffessional1 FROM Connected e WHERE e.Proffessional_idProffessional2 = ?1"+ "UNION" + "SELECT e.Proffessional_idProffessional2 FROM Connected e WHERE e.Proffessional_idProffessional1 = ?1" );
        query.setParameter(1, "%"+id+"%");

        return query.getResultList();

    }

}
