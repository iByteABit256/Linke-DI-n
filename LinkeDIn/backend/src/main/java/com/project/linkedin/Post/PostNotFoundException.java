package com.project.linkedin.Post;

class PostNotFoundException extends RuntimeException {

    PostNotFoundException(Long id) {
        super("Could not find post" + id);
    }
}
