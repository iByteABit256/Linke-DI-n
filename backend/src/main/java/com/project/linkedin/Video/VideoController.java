package com.project.linkedin.Video;



import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class VideoController {

    private final VideoRepository repository;

    VideoController(VideoRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/videos")
    List<Video> all() {
        return repository.findAll();
    }

    @PostMapping("/videos")
    Video newVideo(@RequestBody Video newVideo) {
        return repository.save(newVideo);
    }



    // Single item

    @GetMapping("/videos/{id}")
    Video one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new VideoNotFoundException(id));
    }
}
