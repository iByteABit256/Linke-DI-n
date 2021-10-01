package com.project.linkedin.Comment;


import com.project.linkedin.User.User;

import java.util.List;

public interface CustomCommentRepository {
    Comment findComment(Long postid, Long proffid);
    List<Comment> getPostComments(Long postid);
    List<User> getUsersWhoCommented(Long postid);
}
