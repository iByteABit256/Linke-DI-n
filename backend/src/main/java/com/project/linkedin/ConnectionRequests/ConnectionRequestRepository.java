package com.project.linkedin.ConnectionRequests;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRequestRepository extends JpaRepository<ConnectionRequest, ConnectionRequestPK>, CustomConnectionRequestRepository {
}
