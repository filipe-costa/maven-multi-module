package com.example.mavenmultimodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.mavenmultimodule")
public class MavenMultiModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenMultiModuleApplication.class, args);
    }

}
