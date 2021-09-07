package com.project.linkedin.Picture;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Picture {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_picture;
    private String picture_dir;
    private Long post_id;

    public Picture() {
    }

    public Picture(String picture_dir, Long post_id) {

        this.picture_dir = picture_dir;
        this.post_id = post_id;

    }
}
