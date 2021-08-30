package com.project.linkedin.Picture;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Picture {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idPictures;
    private String picture_dir;
    private Long Post_idPost;

    public Picture() {
    }

    public Picture(String picture_dir, Long Post_idPost) {

        this.picture_dir = picture_dir;
        this.Post_idPost = Post_idPost;

    }
}
