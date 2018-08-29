package com.ay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

/**
 * be used to launch the
 *
 */
@SpringBootApplication(scanBasePackages = "com.ay")
@EnableCaching
@EnableTransactionManagement
@Slf4j
public class ErpApp {
    public static void main( String[] args ){
        SpringApplication.run(ErpApp.class, args);
    }
    /**
     *  create a CommandLineRunner to initiate application during application context starting
     * @param context spring application context
     * @return CommandLineRunner using to take action of initiation
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            log.info("inspect the beans provided by Spring Boot:");

            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                log.info(beanName);
            }

        };
    }
}
