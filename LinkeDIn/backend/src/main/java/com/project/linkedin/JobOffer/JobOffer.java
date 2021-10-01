package com.project.linkedin.JobOffer;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class JobOffer {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_job_offer;
    private Long id_proffessional;
    private String title;
    private String body;

    public JobOffer() {
    }

    public JobOffer(Long id_proffessional,String title,String body) {

        this.id_proffessional = id_proffessional;
        this.title = title;
        this.body = body;

    }


}
