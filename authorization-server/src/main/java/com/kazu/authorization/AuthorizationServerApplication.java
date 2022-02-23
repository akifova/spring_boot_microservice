package com.kazu.authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author akifova
 * @since 27.01.2021
 */
@SpringBootApplication
public class AuthorizationServerApplication {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }
}
