package com.project.linkedin.Discussion;

public class DiscussionNotFoundException extends RuntimeException{
    DiscussionNotFoundException(Long id) { super("Could not find discussion index" + id);
    }
}
