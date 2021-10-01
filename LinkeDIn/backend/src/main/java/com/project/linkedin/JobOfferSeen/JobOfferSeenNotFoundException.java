package com.project.linkedin.JobOfferSeen;

public class JobOfferSeenNotFoundException extends RuntimeException{

    JobOfferSeenNotFoundException(JobOfferSeenPK id) { super("Could not find moderator" + id); }

}
