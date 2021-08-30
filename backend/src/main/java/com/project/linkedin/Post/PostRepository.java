package com.project.linkedin.Post;


import org.springframework.data.jpa.repository.JpaRepository;


interface PostRepository extends JpaRepository<Post,Long> , CustomPostRepository {

}
