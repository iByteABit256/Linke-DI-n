package com.project.linkedin.User;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_user;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String profile_picture_dir;
    private String settings;


    public User() {
    }

    public User(String email, String password,
                String first_name, String last_name,
                String phone_number, String profile_picture_dir,
                String settings) {

        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.profile_picture_dir = profile_picture_dir;
        this.settings = settings;
    }
}
