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
        Query query = entityManager.createQuery("SELECT e FROM Post e WHERE e.proffessional_id = ?1 ORDER BY e.dt DESC");
        query.setParameter(1,id);
        return query.getResultList();
    }


}
