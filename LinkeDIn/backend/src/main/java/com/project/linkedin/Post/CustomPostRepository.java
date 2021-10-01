package com.project.linkedin.Post;


import java.util.List;

public interface CustomPostRepository {

    List<Post> finduserposts(Long id);
    List<Post> findalluserposts(Long id);
    List<Post> allPosts();
    List<Post> getRecommended(Long id, int n);
}
