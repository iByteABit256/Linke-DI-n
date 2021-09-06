package com.project.linkedin.Comment;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomCommentRepositoryImpl implements CustomCommentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Comment findComment(Long postid, Long proffid) {
        Query query = entityManager.createQuery("SELECT e FROM Comment e WHERE e.Post_id= ?1 AND e.Proffessional_id=?2");
        query.setParameter(1, "%" + postid + "%");
        query.setParameter(2, "%" + proffid + "%");
        List<Comment> list =  query.getResultList();
        return list.get(0);

    }
}
