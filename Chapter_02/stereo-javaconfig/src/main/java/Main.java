
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import soundsystem.CDPlayerConfig;
import soundsystem.MediaPlayer;

public class Main {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(CDPlayerConfig.class);
        context.refresh();
       MediaPlayer myPlayer =  context.getBean(MediaPlayer.class);
       myPlayer.play();

    }
}