package com.project.linkedin.Connected;

import org.springframework.data.jpa.repository.JpaRepository;

interface ConnectedRepository extends JpaRepository<Connected, Long>, CustomConnectedRepository {

}
