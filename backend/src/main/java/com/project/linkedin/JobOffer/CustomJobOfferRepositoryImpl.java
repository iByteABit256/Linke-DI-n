package com.project.linkedin.JobOffer;


import com.project.linkedin.MatrixFactorization.MatrixFactorization;
import com.project.linkedin.Post.Post;
import com.project.linkedin.Proffessional.Proffessional;
import org.ejml.simple.SimpleMatrix;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Transactional(readOnly = true)
public class CustomJobOfferRepositoryImpl implements CustomJobOfferRepository{

    @PersistenceContext
    EntityManager entityManager;

    public List<Long> allProffessionalsExcept(Long id_prof) {
        Query query = entityManager.createQuery("SELECT p.id_proffessional FROM Proffessional p WHERE p.id_proffessional<>?1");
        query.setParameter(1, id_prof);
        return query.getResultList();
    }

    public List<JobOffer> allJobOffers() {
        Query query = entityManager.createQuery("SELECT j FROM JobOffer j");
        return query.getResultList();
    }

    public boolean hasSeenJobOffer(Long id_prof, Long id_job_offer){
        Query query = entityManager.createQuery("SELECT COUNT(s) FROM JobOfferSeen s WHERE " +
                "s.id_proffessional=?1 AND s.id_jobOffer=?2");
        query.setParameter(1, id_prof);
        query.setParameter(2, id_job_offer);

        List<Long> l = query.getResultList();
        return l.get(0) > 0;
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

    @Override
    public List<JobOffer> getRecommended(Long id, int n){
        // Columns
        List<JobOffer> jOffers = allJobOffers();

        // Rows
        List<Long> profs = allProffessionalsExcept(id);
        profs.add(0, id);

        double data[][] = new double[profs.size()][jOffers.size()];

        for(int i = 0; i < profs.size(); i++){
            for(int j = 0; j < jOffers.size(); j++){
                int val = 0;
                Long id_prof = profs.get(i);
                Long id_job_offer = jOffers.get(j).getId_job_offer();

                if(hasSeenJobOffer(id_prof, id_job_offer)) val = 1;

                data[i][j] = val;
            }
        }

        SimpleMatrix X = new SimpleMatrix(data);

        X.print();

        int K = 2;
        SimpleMatrix V = SimpleMatrix.random_DDRM(profs.size(),K,0,1,new Random());
        SimpleMatrix F = SimpleMatrix.random_DDRM(jOffers.size(),K,0,1,new Random());

        V.print();
        F.print();

        X = MatrixFactorization.mf(X, V, F, K, 1000, 0.008, 0.001);

        X.print();

        double top_row[] = X.rows(0,1).getDDRM().data;

        List<JobOffer> res = new ArrayList<JobOffer>();
        ArrayList<Integer> max_indices = nMax(top_row, n);

        for(int idx: max_indices){
            res.add(jOffers.get(idx));
        }

        return res;
    }
}
