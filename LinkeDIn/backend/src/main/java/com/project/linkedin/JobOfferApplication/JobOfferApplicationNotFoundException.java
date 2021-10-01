package com.project.linkedin.JobOfferApplication;



public class JobOfferApplicationNotFoundException extends RuntimeException{

    JobOfferApplicationNotFoundException(JobOfferApplicationPK id) { super("Could not find job offer application" + id); }
}
