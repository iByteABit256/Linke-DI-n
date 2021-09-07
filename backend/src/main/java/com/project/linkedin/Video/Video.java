package com.project.linkedin.Video;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Video {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_video;
    private String video_dir;
    private Long post_id;

    public Video() {
    }

    public Video(String video_dir, Long post_id) {

        this.video_dir = video_dir;
        this.post_id = post_id;

    }

}
