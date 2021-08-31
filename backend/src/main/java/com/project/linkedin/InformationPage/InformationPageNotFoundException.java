package com.project.linkedin.InformationPage;


public class InformationPageNotFoundException extends RuntimeException{

    InformationPageNotFoundException(Long id) {
        super("Could not find information page " + id);
    }
}
