package com.project.linkedin.Post;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Post {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idPost;
    private Long Proffessional_idProffessional;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Long Proffessional_idProffessional,String title,String  body) {

        this.Proffessional_idProffessional = Proffessional_idProffessional;
        this.title = title;
        this.body = body;

    }
}
