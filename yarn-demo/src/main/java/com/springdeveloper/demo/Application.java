package com.springdeveloper.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.yarn.annotation.OnContainerStart;
import org.springframework.yarn.annotation.YarnComponent;
import org.springframework.yarn.config.annotation.configuration.SpringYarnContainerConfiguration;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        System.out.println("*** RUNNING");
        SpringYarnContainerConfiguration c = new SpringYarnContainerConfiguration();

        SpringApplication.run(Application.class, args);
    }

    @YarnComponent
    @Profile("container")
    public static class HelloPojo {

        private static final Log log = LogFactory.getLog(HelloPojo.class);

        @OnContainerStart
        public void onStart() throws Exception {
            log.info("Hello from YARN!");
        }

    }

}