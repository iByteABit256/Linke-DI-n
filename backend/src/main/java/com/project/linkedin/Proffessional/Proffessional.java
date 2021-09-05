package com.project.linkedin.Proffessional;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Proffessional {


    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idProffessional;
    private Long User_id;
    private Long InformationPage_id;


    public Proffessional() {
    }

    public Proffessional(Long User_id, Long InformationPage_id) {


        this.User_id = User_id;
        this.InformationPage_id = InformationPage_id;

    }

}
