package com.project.linkedin.Comment;


import java.util.List;

public interface CustomCommentRepository {
    Comment findComment(Long postid, Long proffid);
}
