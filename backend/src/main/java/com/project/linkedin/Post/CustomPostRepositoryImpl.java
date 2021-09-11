package com.project.linkedin.Post;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomPostRepositoryImpl implements CustomPostRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> finduserposts(Long id){
        Query query = entityManager.createQuery("SELECT e FROM Post e WHERE e.id_proffessional = ?1 ORDER BY e.dt DESC");
        query.setParameter(1,id);
        return query.getResultList();
    }

    public List<Post> findalluserposts(Long id){
        Query query = entityManager.createQuery("SELECT p FROM Post p WHERE ( (p.id_proffessional IN (SELECT c.id_proffessional1 FROM Connected c WHERE c.id_proffessional2 = ?1)) OR (p.id_proffessional IN (SELECT c.id_proffessional2 FROM Connected c  WHERE c.id_proffessional1 = 3)) OR p.id_proffessional=3) ORDER BY p.dt DESC");
        query.setParameter(1,id);
        return query.getResultList();

    }




}
