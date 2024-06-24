package org.has;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PatienceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatienceServiceApplication.class);
    }
}