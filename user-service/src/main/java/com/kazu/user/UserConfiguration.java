package com.kazu.user;

import com.kazu.user.config.MapStructActiveFieldMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author akifova
 * @since 21.01.2021
 */
@Configuration
public class UserConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(UserConfiguration.class);

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
