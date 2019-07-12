package com.example.starter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Getter
@Setter
@Configuration
public class ApplicationConfig implements EnvironmentAware {
    private String projectName;

    private static Environment environment;

    @Override
    public void setEnvironment(Environment envir) {
        if (environment == null) {
            environment = envir;
        }
    }

    public static String load(String systemProperties) {
        return environment.getProperty(systemProperties);
    }

}
