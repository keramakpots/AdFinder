package com.codecool.adfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AdfinderApplication {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        SpringApplication.run(AdfinderApplication.class, args);
    }
}
