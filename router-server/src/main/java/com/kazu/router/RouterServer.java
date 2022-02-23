package com.kazu.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author akifova
 * @since 21.01.2021
 */
@SpringBootApplication
public class RouterServer {
    private static final Logger logger = LoggerFactory.getLogger(RouterServer.class);

    public static void main(String[] args) {
        SpringApplication.run(RouterServer.class, args);
        logger.info("CaRP Router Started...");
    }
}
