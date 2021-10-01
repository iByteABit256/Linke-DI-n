package com.project.linkedin.InformationPage;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional(readOnly = false)
public class CustomInformationPageRepositoryImpl implements CustomInformationPageRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public InformationPage finduserinformationpage(Long id_user){
        Query q = entityManager.createQuery("SELECT i FROM InformationPage  i WHERE i.id_information_page IN(SELECT p.id_information_page FROM Proffessional p WHERE p.id_user =?1)");
        q.setParameter(1, id_user);
        List <InformationPage> list= q.getResultList();
        if(list.size() == 0){
            return null;
        }

        return list.get(0);

    }

    @Override
    public int changeworkexperience(Long id_information_page,String newworkexp){
        Query q = entityManager.createQuery("UPDATE InformationPage i SET i.work_experience=?2 WHERE i.id_information_page=?1");
        q.setParameter(1, id_information_page);
        q.setParameter(2, newworkexp);
        return q.executeUpdate();

    }

    @Override
    public int changebio(Long id_information_page,String newbio){
        Query q = entityManager.createQuery("UPDATE InformationPage i SET i.bio=?2 WHERE i.id_information_page=?1");
        q.setParameter(1, id_information_page);
        q.setParameter(2, newbio);
        return q.executeUpdate();
    }

}
