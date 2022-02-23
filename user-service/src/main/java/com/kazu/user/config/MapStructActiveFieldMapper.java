package com.kazu.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author akifova
 * @since 24.01.2021
 */
@Component
public class MapStructActiveFieldMapper {
    private static final Logger logger = LoggerFactory.getLogger(MapStructActiveFieldMapper.class);

    public short aShort(Boolean active) {
        return active ? (short) 1 : (short) 0;
    }

    public boolean aBoolean(short active) {
        return active == (short) 1 ? true : false;
    }
}
