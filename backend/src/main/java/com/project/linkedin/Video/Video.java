package com.project.linkedin.Video;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Video {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long idVideo;
    private String video_dir;
    private Long Post_id;

    public Video() {
    }

    public Video(String video_dir, Long Post_id) {

        this.video_dir = video_dir;
        this.Post_id = Post_id;

    }

}
