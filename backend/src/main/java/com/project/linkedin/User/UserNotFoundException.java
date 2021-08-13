package com.project.linkedin.User;

class UserNotFoundException extends RuntimeException {

    UserNotFoundException(Long id) {
        super("Could not find user" + id);
    }
}
