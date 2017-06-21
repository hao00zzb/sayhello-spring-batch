package com.suntomor.springbatch.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

public final class StartServer {

    private static final Logger logger = LoggerFactory.getLogger(StartServer.class);

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "alpha");
        final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
        classPathXmlApplicationContext.start();
        logger.info("start suntomor-springbatch-job service.....");

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("stop suntomor-springbatch-job service.....");
                classPathXmlApplicationContext.registerShutdownHook();
            }
        }));
    }

}
