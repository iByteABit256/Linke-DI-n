package com.project.linkedin.Message;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional(readOnly = true)
public class CustomMessageRepositoryImpl implements CustomMessageRepository{

    @PersistenceContext
    EntityManager entityManager;

}
