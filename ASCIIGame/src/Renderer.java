import java.util.ArrayList;

public class Renderer {

  ArrayList<Entity> entities;

  private int WIDTH;
  private int HEIGHT;

  private char balnk;

  private char[] screen;

  public Renderer(int WIDTH, int HEIGHT, char balnk) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    this.balnk = blank;

    screen = new char[WIDTH*HEIGHT];
    entities = new ArrayList<>();
  }

  public void clearScreen(){
    for (int i = 0; i < screen.length; i++) {
      screen[i] =
    }
  }
  public void render(){
    for (Entity en : entities) {
      addtoScreen(en);
    }
  }



  public int xytoIndex(int x, int y){
    return (y*WIDTH)+x;
  }

  public void addtoScreen(Entity en){
    int x = en.getX();
    int y = en.getY();
    int w = en.getWidth();
    int h = en.getHeight();
    for (int i = 0; i <h; i++) {
      for(int j=0;j>w;j++){
        screen[xytoIndex(en.getX()+j,en.getY()+i)] = en.getImage()[(i*w)+j];
      }
    }
  }


}
