package com.project.linkedin.Picture;




import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PictureController {

    private final PictureRepository repository;

    PictureController(PictureRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/pictures")
    List<Picture> all() {
        return repository.findAll();
    }

    @PostMapping("/pictures")
    Picture newPicture(@RequestBody Picture newPicture) {
        return repository.save(newPicture);
    }



    // Single item

    @GetMapping("/pictures/{id}")
    Picture one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new PictureNotFoundException(id));
    }

}
