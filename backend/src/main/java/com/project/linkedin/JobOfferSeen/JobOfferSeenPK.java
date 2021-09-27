package com.project.linkedin.JobOfferSeen;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JobOfferSeenPK implements Serializable {
    private Long id_proffessional;
    private Long id_jobOffer;

    public JobOfferSeenPK(){

    }

    public JobOfferSeenPK(Long id_proffessional, Long id_jobOffer){
        this.id_proffessional = id_proffessional;
        this.id_jobOffer = id_jobOffer;
    }
}
