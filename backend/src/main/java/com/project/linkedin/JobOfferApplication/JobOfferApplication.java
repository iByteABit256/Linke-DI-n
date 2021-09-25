package com.project.linkedin.JobOfferApplication;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@IdClass(JobOfferApplicationPK.class)
public class JobOfferApplication implements Serializable{
    private @Id Long id_proffessional;
    private @Id Long id_job_offer;

    public JobOfferApplication() {
    }

    public JobOfferApplication( Long id_proffessional, Long id_job_offer ) {

        this.id_proffessional = id_proffessional;
        this.id_job_offer = id_job_offer;

    }
}
