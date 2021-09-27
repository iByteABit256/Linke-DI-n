package com.project.linkedin.DiscussionIndex;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionIndexRepository extends JpaRepository<DiscussionIndex,DiscussionIndexPK> , CustomDiscussionIndexRepository {
}
