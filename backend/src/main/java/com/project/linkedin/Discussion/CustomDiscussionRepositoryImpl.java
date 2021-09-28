package com.project.linkedin.Discussion;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional(readOnly = true)
public class CustomDiscussionRepositoryImpl implements CustomDiscussionRepository {

    @PersistenceContext
    EntityManager entityManager;

}
