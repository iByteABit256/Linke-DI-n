package com.project.linkedin.Picture;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Picture {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idPicture;
    private String picture_dir;
    private Long Post_id;

    public Picture() {
    }

    public Picture(String picture_dir, Long Post_id) {

        this.picture_dir = picture_dir;
        this.Post_id = Post_id;

    }
}
