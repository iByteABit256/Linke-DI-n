package com.project.linkedin.Moderator;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeratorRepository  extends JpaRepository<Moderator,Long> , CustomModeratorRepository {
}
