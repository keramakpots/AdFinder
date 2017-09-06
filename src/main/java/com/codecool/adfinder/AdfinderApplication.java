package com.codecool.adfinder;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdfinderApplication {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        SpringApplication.run(AdfinderApplication.class, args);
    }
}
