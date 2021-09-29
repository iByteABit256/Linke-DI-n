package com.project.linkedin.ConnectionRequests;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRequestsRepository extends JpaRepository<ConnectionRequests, ConnectionRequestsPK>, CustomConnectionRequestsRepository {
}
