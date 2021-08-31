package com.project.linkedin.InformationPage;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class CustomInformationPageRepositoryImpl implements CustomInformationPageRepository {

    @PersistenceContext
    EntityManager entityManager;

}
