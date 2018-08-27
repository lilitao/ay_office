package com.ay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * be used to launch the
 *
 */
@SpringBootApplication(scanBasePackages = "com.ay")
public class App {
    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
}
