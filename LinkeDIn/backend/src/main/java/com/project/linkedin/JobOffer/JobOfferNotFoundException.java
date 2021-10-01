package com.project.linkedin.JobOffer;



public class JobOfferNotFoundException extends RuntimeException{
    JobOfferNotFoundException(Long id) { super("Could not find moderator" + id); }
}
