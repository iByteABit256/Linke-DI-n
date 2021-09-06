package com.project.linkedin.InformationPage;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class InformationPage {
    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_information_page;
    private String bio;
    private String work_experience;

    public InformationPage() {
    }

    public InformationPage(String bio, String work_experience) {

        this.bio = bio;
        this.work_experience = work_experience;

    }
}
