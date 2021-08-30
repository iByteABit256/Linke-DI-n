package com.project.linkedin.Picture;


import org.springframework.data.jpa.repository.JpaRepository;


interface PictureRepository extends JpaRepository<Picture,Long> , CustomPictureRepository {

}
