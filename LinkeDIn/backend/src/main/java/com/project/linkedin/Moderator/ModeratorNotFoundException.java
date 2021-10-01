package com.project.linkedin.Moderator;

public class ModeratorNotFoundException extends RuntimeException{

    ModeratorNotFoundException(Long id) { super("Could not find moderator" + id); }

}
