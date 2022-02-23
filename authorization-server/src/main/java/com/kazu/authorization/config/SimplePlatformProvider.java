package com.kazu.authorization.config;

import org.keycloak.platform.PlatformProvider;
import org.keycloak.services.ServicesLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akifova
 * 28.01.2021
 */
public class SimplePlatformProvider implements PlatformProvider {
    private static final Logger logger = LoggerFactory.getLogger(SimplePlatformProvider.class);

    Runnable shutdownHook;

    @Override
    public void onStartup(Runnable startupHook) {
        startupHook.run();
    }

    @Override
    public void onShutdown(Runnable shutdownHook) {
        this.shutdownHook = shutdownHook;
    }

    @Override
    public void exit(Throwable cause) {
        ServicesLogger.LOGGER.fatal(cause);
        exit(1);
    }

    private void exit(int status) {
        new Thread() {
            @Override
            public void run() {
                System.exit(status);
            }
        }.start();
    }
}
