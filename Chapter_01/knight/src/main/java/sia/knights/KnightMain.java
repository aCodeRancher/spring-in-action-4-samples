package sia.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.
                   ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class KnightMain {

  public static void main(String[] args) throws Exception {
    ApplicationContext context =
        new FileSystemXmlApplicationContext(
            "classpath:META-INF/spring/knight.xml");
    Knight knight = (Knight)context.getBean("knight1");
    knight.embarkOnQuest();

  }

}
