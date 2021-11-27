package com.wsp.crontab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class CrontabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrontabApplication.class, args);
    }

}
