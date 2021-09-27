package com.project.linkedin.DiscussionIndex;

public class DiscussionIndexNotFoundException extends RuntimeException{
    DiscussionIndexNotFoundException(Long id) { super("Could not find discussion index" + id);
    }
}
