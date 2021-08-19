package com.project.linkedin.Proffessional;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Proffessional {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idProffessional;
    private Long User_idUser;
    private Long InformationPage_idInformationPage;

    public Proffessional() {
    }

    public Proffessional(Long User_idUser, Long InformationPage_idInformationPage) {

        this.User_idUser = User_idUser;
        this.InformationPage_idInformationPage = InformationPage_idInformationPage;

    }

}
