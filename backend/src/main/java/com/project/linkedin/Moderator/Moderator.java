package com.project.linkedin.Moderator;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Moderator {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long ididModerator;
    private Long User_idUser;

    public Moderator() {
    }

    public Moderator( Long User_idUser) {

        this.User_idUser = User_idUser;

    }
}
