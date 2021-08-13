package com.project.linkedin.User;


import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

}
