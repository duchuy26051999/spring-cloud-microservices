package com.fnkaya.mentorship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class MentorshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentorshipApplication.class, args);
    }
}
