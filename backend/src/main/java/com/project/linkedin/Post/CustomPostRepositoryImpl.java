package com.project.linkedin.Post;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ejml.simple.SimpleMatrix;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;

import com.project.linkedin.Connected.CustomConnectedRepository;
import com.project.linkedin.MatrixFactorization.matrixfactorization;

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
        Query query = entityManager.createQuery("SELECT p FROM Post p WHERE ( (p.id_proffessional IN (" +
                "SELECT c.id_proffessional1 FROM Connected c WHERE c.id_proffessional2 = ?1)) OR (" +
                "p.id_proffessional IN (SELECT c.id_proffessional2 FROM Connected c  WHERE c.id_proffessional1 = ?1)) OR " +
                "p.id_proffessional=?1) ORDER BY p.dt DESC");

        query.setParameter(1,id);
        return query.getResultList();
    }

    @Override
    public List<Post> allPosts() {
        Query query = entityManager.createQuery("SELECT p FROM Post p");
        return query.getResultList();
    }

    public List<Post> getRecommended(Long id, int n){
        //List<Post> posts = allPosts();
        //List<Long> proffessionals = CustomConnectedRepository.getConnectedUsers(id);

        double data[][] = {{5,3,0,1},{4,0,0,1},{1,1,0,5},{1,0,0,4},{0,1,5,4},{2,1,3,0}};
        SimpleMatrix X = new SimpleMatrix(data);

        X.print();

        int K = 3;
        SimpleMatrix V = SimpleMatrix.random_DDRM(6,3,0,5,new Random());
        SimpleMatrix F = SimpleMatrix.random_DDRM(4,3,0,5,new Random());

        V.print();
        F.print();

        X = matrixfactorization.mf(X, V, F, K, 5000, 0.0002, 0.02);

        X.print();

        return null;
    }

}
