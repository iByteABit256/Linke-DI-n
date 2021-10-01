package com.project.linkedin.Video;

public class VideoNotFoundException extends RuntimeException{

    VideoNotFoundException(Long id) {
        super("Could not find video " + id);
    }

}
