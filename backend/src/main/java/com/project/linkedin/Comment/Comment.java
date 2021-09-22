package com.project.linkedin.Comment;




import lombok.Data;

import javax.persistence.*;



@Data
@Entity
public class Comment {
    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_comment;
    private Long id_proffessional;
    private Long id_post;
    private String body;

    public Comment() {
    }

    public Comment(Long id_proffessional, Long id_post, String body) {

        this.id_proffessional = id_proffessional;
        this.id_post = id_post;
        this.body = body;

    }

}


