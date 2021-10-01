package com.project.linkedin.InterestDeclaration;

import com.project.linkedin.User.User;

import java.util.List;

public interface CustomInterestDeclarationRepository {
    Long getPostLikes(Long id_post);
    List<User> getUsersWhoLiked(Long id_post);
}
