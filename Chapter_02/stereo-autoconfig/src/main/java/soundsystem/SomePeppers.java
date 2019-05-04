package soundsystem;
import org.springframework.stereotype.Component;

@Component ("BPeppers")
public class SomePeppers implements CompactDisc {
    private String title = "Some peppers";
    private String artist = "The Butterfly";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
