package com.project.linkedin.Proffessional;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Proffessional {


    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idProffessional;
    private Long id_user;
    private Long id_information_page;


    public Proffessional() {
    }

    public Proffessional(Long User_id, Long InformationPage_id) {


        this.id_user = User_id;
        this.id_information_page = InformationPage_id;

    }

}
