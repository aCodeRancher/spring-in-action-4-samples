package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")

public class EnvironmentConfig {

  @Autowired
  Environment env;


  @Value("${disc.title}")
  private String title;

  @Value ("${disc.artist}")
  private String artist;
  @Bean
  public BlankDisc blankDisc() {
    return new BlankDisc(
        title,
        artist);
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
    return new PropertySourcesPlaceholderConfigurer();
  }
}
