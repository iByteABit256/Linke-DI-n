package com.project.linkedin.JobOfferApplication;


import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
public class JobOfferApplicationPK implements Serializable{
    private  Long id_proffessional;
    private  Long id_job_offer;
}
