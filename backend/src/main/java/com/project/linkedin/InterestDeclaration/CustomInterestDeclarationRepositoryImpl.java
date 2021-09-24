package com.project.linkedin.InterestDeclaration;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomInterestDeclarationRepositoryImpl implements CustomInterestDeclarationRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Long getPostLikes(Long id_post){
        Query q = entityManager.createQuery("SELECT COUNT(i.id_proffessional) FROM InterestDeclaration i WHERE i.id_post = ?1" );
        q.setParameter(1, id_post);
        List res =  q.getResultList();
        return (Long) res.get(0);
    }

}
