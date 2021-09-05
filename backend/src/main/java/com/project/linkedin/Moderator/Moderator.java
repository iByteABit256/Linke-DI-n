package com.project.linkedin.Moderator;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Moderator {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idModerator;
    private Long User_id;

    public Moderator() {
    }

    public Moderator( Long User_id) {

        this.User_id = User_id;

    }
}
