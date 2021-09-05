package com.project.linkedin.Post;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Post {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idPost;
    private Long Proffessional_id;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Long Proffessional_id,String title,String  body) {

        this.Proffessional_id = Proffessional_id;
        this.title = title;
        this.body = body;

    }
}
