package com.project.linkedin.Post;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Post {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_post;
    private Long id_proffessional;
    private String title;
    private String body;
    private String dt;

    public Post() {
    }

    public Post(Long id_proffessional, String title, String  body, String dt) {

        this.id_proffessional = id_proffessional;
        this.title = title;
        this.body = body;
        this.dt = dt;

    }
}
