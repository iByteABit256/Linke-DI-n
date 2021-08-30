package com.project.linkedin.Comment;

public class CommentNotFoundException extends RuntimeException {

    CommentNotFoundException(Long id) {
        super("Could not find comment" + id);
    }
}
