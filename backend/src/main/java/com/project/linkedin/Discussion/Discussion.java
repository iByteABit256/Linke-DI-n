package com.project.linkedin.Discussion;

import lombok.Data;

import javax.persistence.*;




@Data
@Entity
public class Discussion {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_discussion;
    private Long id_sender;
    private String message;
    private String dt;

    public Discussion() {
    }

    public Discussion(Long id_sender,String message, String dt) {

        this.id_sender= id_sender;
        this.message = message;
        this.dt= dt;

    }
}
