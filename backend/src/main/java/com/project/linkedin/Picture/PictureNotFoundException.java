package com.project.linkedin.Picture;

class PictureNotFoundException extends RuntimeException {

    PictureNotFoundException(Long id) {
        super("Could not find picture" + id);
    }
}
