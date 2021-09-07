package com.project.linkedin.Post;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Post {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_post;
    private Long proffessional_id;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Long proffessional_id,String title,String  body) {

        this.proffessional_id = proffessional_id;
        this.title = title;
        this.body = body;

    }
}
