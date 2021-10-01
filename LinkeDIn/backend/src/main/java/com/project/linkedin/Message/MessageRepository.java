package com.project.linkedin.Message;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> , CustomMessageRepository {
}
