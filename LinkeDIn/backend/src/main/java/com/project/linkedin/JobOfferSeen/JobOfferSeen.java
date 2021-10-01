package com.project.linkedin.JobOfferSeen;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@IdClass(JobOfferSeenPK.class)
public class JobOfferSeen implements Serializable {

    private @Id Long id_proffessional;
    private @Id Long id_jobOffer;

    public JobOfferSeen() {
    }

    public JobOfferSeen( Long id_user, Long id_jobOffer ) {

        this.id_proffessional = id_user;
        this.id_jobOffer = id_jobOffer;

    }
}
