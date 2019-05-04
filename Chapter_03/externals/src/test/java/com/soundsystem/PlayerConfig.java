package com.soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfig {

     @Bean (name = "cd")
     @CDDisc
      public MediaPlayer mediaPlayer(){
         return new  CDPlayer();
     }

      @Bean (name ="radio")
      @Tape
       public MediaPlayer mediaPlayer1(){
         return new Radio();
      }
}
