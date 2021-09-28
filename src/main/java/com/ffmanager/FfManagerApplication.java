package com.ffmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FfManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FfManagerApplication.class, args);
    }

}
