package com.example.jobalert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobAlertApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobAlertApplication.class, args);
    }
}