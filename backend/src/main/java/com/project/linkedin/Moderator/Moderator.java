package com.project.linkedin.Moderator;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Moderator {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_moderator;
    private Long user_id;

    public Moderator() {
    }

    public Moderator( Long user_id) {

        this.user_id = user_id;

    }
}
