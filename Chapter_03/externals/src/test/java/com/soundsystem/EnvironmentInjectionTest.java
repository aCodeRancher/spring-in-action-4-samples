package com.soundsystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.soundsystem.CDDisc;
public class EnvironmentInjectionTest {

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=EnvironmentConfig.class)
  public static class InjectFromProperties {

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void assertBlankDiscProperties() {
      assertEquals("The Beatles", blankDisc.getArtist());
      assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
    }

  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=SystemConfig.class)
  public static class InjectFromSystem {

    @Autowired
    private BlankDisc blankDisc;

    @BeforeClass
    public static void beforeTest(){
      System.setProperty("disc.title", "Peppers");
      System.setProperty("disc.artist", "Lone") ;
    }
    @Test
    public void assertBlankDiscProperties() {
      assertEquals("Lone", blankDisc.getArtist());
      assertEquals("Peppers", blankDisc.getTitle());
    }

  }
  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes=EnvironmentConfigWithDefaults.class)
  public static class InjectFromPropertiesWithDefaultValues {
  
    @Autowired
    private BlankDisc blankDisc;
    
    @Test
    public void assertBlankDiscProperties() {
      assertEquals("U2", blankDisc.getArtist());
      assertEquals("Rattle and Hum", blankDisc.getTitle());
    }
    
  }

  public static class InjectFromPropertiesWithRequiredProperties {


    //@Test(expected=BeanCreationException.class)
    @Test
    public void assertBlankDiscProperties() {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnvironmentConfigWithRequiredProperties.class);
      BlankDisc disc = context.getBean(BlankDisc.class);
      assertEquals("The Beatles",  disc.getArtist());
      assertEquals("Sgt. Peppers Lonely Hearts Club Band", disc.getTitle());
    }
    
  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration("classpath:placeholder-config.xml")
  public static class InjectFromProperties_XMLConfig {
  
    @Autowired
    private BlankDisc blankDisc;
    
    @Test
    public void assertBlankDiscProperties() {
      assertEquals("beatle", blankDisc.getArtist());
      assertEquals("Lone", blankDisc.getTitle());
    }
    
  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration("classpath:placeholder1-config.xml")
  public static class InjectFromProperties_XMLConfig1 {

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void assertBlankDiscProperties() {
      assertEquals("beatle", blankDisc.getArtist());
      assertEquals("Lone", blankDisc.getTitle());
    }

  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes = PlayerConfig.class)
  public static class InjectFromPlayerConfig {

    @Autowired
    @CDDisc
    private MediaPlayer player;

    @Autowired
    @Tape
    private MediaPlayer player1;

    @Test
    public void assertPlayerProperties() {
      assertEquals("CD Player",  player.play());
      assertEquals("Radio player",  player1.play());
    }

  }
}