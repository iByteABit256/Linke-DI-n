package com.project.linkedin.Discussion;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository<Discussion,Long> , CustomDiscussionRepository {
}
