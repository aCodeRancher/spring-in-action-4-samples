package com.soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
public class SystemConfig {


    @Value("#{systemProperties['disc.title']}")
    private String title;

    @Value ("#{systemProperties['disc.artist']}")
    private String artist;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                title,
                artist);
    }


}
