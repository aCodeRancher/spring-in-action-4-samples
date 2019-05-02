package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  @Autowired
  public CDPlayer(@Qualifier("somePeppers")CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

}
