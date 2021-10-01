package com.project.linkedin.InterestDeclaration;

public class InterestDeclarationNotFoundException extends RuntimeException{

    InterestDeclarationNotFoundException(InterestDeclarationPK id) { super("Could not find moderator" + id); }

}
