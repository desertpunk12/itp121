import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Renderer render = new Renderer( 60,20,' ');
    Player player = new Player(10,10,1,1,new char[]{'@'},render);
    while(true){
      render.render();
      player.handleInput();
    }
  }
}
