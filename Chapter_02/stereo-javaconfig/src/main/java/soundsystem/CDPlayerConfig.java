package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
public class CDPlayerConfig {
  
  @Bean
  public CompactDisc compactDisc() {
    return new SgtPeppers();
  }

  @Bean
  @Qualifier("somePeppers")
  public CompactDisc compactDisc1() {return new SomePeppers();}

  @Bean
  public CDPlayer cdPlayer(@Qualifier("compactDisc")CompactDisc compactDisc) {
    return new CDPlayer(compactDisc);
  }

}
