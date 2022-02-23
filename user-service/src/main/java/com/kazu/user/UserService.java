package com.kazu.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author akifova
 * @since 21.01.2021
 */
@RefreshScope
@SpringBootApplication
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static void main(String[] args) {
        SpringApplication.run(UserService.class, args);
        logger.info("CaRP User Service Started...");
    }
}
