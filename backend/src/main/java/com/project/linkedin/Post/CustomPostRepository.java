package com.project.linkedin.Post;


import java.util.List;

public interface CustomPostRepository {

    List<Post> finduserposts(Long id);
}
