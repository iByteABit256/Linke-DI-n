package com.project.linkedin.Moderator;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Moderator {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_moderator;
    private Long id_user;

    public Moderator() {
    }

    public Moderator( Long id_user) {

        this.id_user = id_user;

    }
}
