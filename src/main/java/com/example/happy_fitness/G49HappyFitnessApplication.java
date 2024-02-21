package com.example.happy_fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class G49HappyFitnessApplication {

    public static void main(String[] args) {
        SpringApplication.run(G49HappyFitnessApplication.class, args);
    }

}
