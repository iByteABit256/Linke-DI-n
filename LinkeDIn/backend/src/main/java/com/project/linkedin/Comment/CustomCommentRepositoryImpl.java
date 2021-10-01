package com.project.linkedin.Comment;


import com.project.linkedin.User.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
@Transactional(readOnly = true)
public class CustomCommentRepositoryImpl implements CustomCommentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Comment findComment(Long postid, Long proffid) {
        Query query = entityManager.createQuery("SELECT e FROM Comment e WHERE e.id_post=?1 AND e.id_proffessional=?2");
        query.setParameter(1, postid);
        query.setParameter(2, proffid);
        List<Comment> list =  query.getResultList();
        return list.get(0);

    }

    @Override
    public List<Comment> getPostComments(Long postid) {
        Query query = entityManager.createQuery("SELECT c FROM Comment c WHERE c.id_post=?1");
        query.setParameter(1, postid);
        return query.getResultList();
    }

    @Override
    public List<User> getUsersWhoCommented(Long postid) {
        Query query = entityManager.createNativeQuery("SELECT * FROM (SELECT A.id_user, email, password, first_name, last_name, phone_number FROM (SELECT id_user FROM comment LEFT JOIN proffessional ON comment.id_proffessional=proffessional.id_proffessional AND id_post=?1) AS A LEFT JOIN user ON A.id_user=user.id_user) AS B WHERE B.id_user IS NOT NULL",User.class);
        query.setParameter(1, postid);
        List<User> result=query.getResultList();

        return result;
    }
}
