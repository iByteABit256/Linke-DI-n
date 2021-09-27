package com.project.linkedin.Post;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ejml.simple.SimpleMatrix;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.project.linkedin.MatrixFactorization.MatrixFactorization;

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

    private List<Long> getConnectedProffessionals(Long id){
        Query query = entityManager.createQuery("SELECT p.id_proffessional FROM Proffessional p WHERE p.id_proffessional IN(" +
                "SELECT e.id_proffessional1 FROM Connected e WHERE e.id_proffessional2 = ?1)" +
                "OR p.id_proffessional IN(" +
                "SELECT e.id_proffessional2 FROM Connected e WHERE e.id_proffessional1 = ?1)");

        query.setParameter(1, id);
        return query.getResultList();
    }

    public boolean hasLikedPost(Long id_prof, Long id_post){
        Query query = entityManager.createQuery("SELECT COUNT(i) FROM InterestDeclaration i" +
                " WHERE i.id_proffessional=?1 AND i.id_post=?2");

        query.setParameter(1, id_prof);
        query.setParameter(2, id_post);

        return (Long) query.getResultList().get(0) > 0;
    }

    public boolean hasCommentedPost(Long id_prof, Long id_post){
        Query query = entityManager.createQuery("SELECT COUNT(c) FROM Comment c" +
                " WHERE c.id_proffessional=?1 AND c.id_post=?2");

        query.setParameter(1, id_prof);
        query.setParameter(2, id_post);

        return (Long) query.getResultList().get(0) > 0;
    }

    public boolean exists(ArrayList<Integer> arr, int val){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == val){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> nMax(double arr[], int n){
        ArrayList<Integer> max_indices = new ArrayList<Integer>();

        if(arr.length < n){
            for(int i = 0; i < arr.length; i++) max_indices.add(i);

            return max_indices;
        }

        while(max_indices.size() < n){
            double max = -1;
            int max_ind = -1;

            for(int i = 0; i < arr.length; i++){
                if(exists(max_indices, i)) continue;

                if(arr[i] >= max){
                    max = arr[i];
                    max_ind = i;
                }
            }
            max_indices.add(max_ind);
        }

        return max_indices;
    }

    public List<Post> getRecommended(Long id, int n){

        // Columns
        List<Post> posts = allPosts();

        // Rows
        List<Long> profs = getConnectedProffessionals(id);
        profs.add(0, id);

        double data[][] = new double[profs.size()][posts.size()];

        for(int i = 0; i < profs.size(); i++){
            for(int j = 0; j < posts.size(); j++){
                int val = 0;
                Long id_prof = profs.get(i);
                Long id_post = posts.get(j).getId_post();

                if(hasCommentedPost(id_prof, id_post)) val += 1;
                if(hasLikedPost(id_prof, id_post)) val += 2;

                data[i][j] = val;
            }
        }

        SimpleMatrix X = new SimpleMatrix(data);

        X.print();

        int K = 2;
        SimpleMatrix V = SimpleMatrix.random_DDRM(profs.size(),K,0,3,new Random());
        SimpleMatrix F = SimpleMatrix.random_DDRM(posts.size(),K,0,3,new Random());

        V.print();
        F.print();

        X = MatrixFactorization.mf(X, V, F, K, 1000, 0.008, 0.001);

        X.print();

        double top_row[] = X.rows(0,1).getDDRM().data;

        List<Post> res = new ArrayList<Post>();
        ArrayList<Integer> max_indices = nMax(top_row, n);

        for(int idx: max_indices){
            res.add(posts.get(idx));
        }

        return res;
    }

}
