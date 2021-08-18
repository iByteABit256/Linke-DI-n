package com.project.linkedin.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
//            log.info("Preloading " + repository.save(new User("jsins69@hotmail.com",
//                    "ieatpussyeveryday", "Johnny", "Sins", "6969696969",
//                    "./test/jsins.png", "./settings/jsins.conf")));
        };
    }
}
