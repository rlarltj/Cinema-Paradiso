package com.prgrms.movieprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MoviePrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviePrjApplication.class, args);
    }

}
