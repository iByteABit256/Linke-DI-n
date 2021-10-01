package com.project.linkedin.Message;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Message {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_message;
    private Long id_discussion;
    private Long id_sender;
    private String message;
    private String dt;

    public Message() {
    }

    public Message(Long id_message, Long id_discussion, Long id_sender, String message, String dt) {

        this.id_message = id_message;
        this.id_discussion= id_discussion;
        this.id_sender= id_sender;
        this.message = message;
        this.dt= dt;

    }
}
