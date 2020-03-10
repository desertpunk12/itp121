import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Renderer {

  ArrayList<Entity> entities;

  private int WIDTH;
  private int HEIGHT;

  private char blank;

  private char[] screen;

  PrintWriter pw;

  public Renderer(int WIDTH, int HEIGHT, char blank) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    this.blank = blank;

    screen = new char[(WIDTH + 2) * (HEIGHT+1)];
    entities = new ArrayList<>();
    pw = new PrintWriter(System.out);
  }

  public void clearScreen() {
    clearTerminal();
    screen[0]=blank;
//    screen[0] = (char)('a'+(0%WIDTH));
    for (int i = 1; i < screen.length-(WIDTH+2)+1; i++) {
      if (i % (WIDTH+2) == 0 ) {
        screen[i-2] = '|';
        screen[i-1] = '\n';
        screen[i] = blank;
        continue;
      }
//      screen[i] = (char)('a'+(i%WIDTH));
      screen[i] = blank;
    }
    for (int i = screen.length-(WIDTH+2); i < screen.length-2; i++) {
      screen[i]='-';
    }
    screen[screen.length-2] = '|';
  }

  public void clearTerminal() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public int getWIDTH() {
    return WIDTH;
  }

  public int getHEIGHT() {
    return HEIGHT;
  }

  public void render() {
    clearScreen();
    for (Entity en : entities) {
      addtoScreen(en);
    }
//    System.out.println(String.valueOf(screen));
    pw.write(String.valueOf(screen));
    pw.flush();
  }


  public int xytoIndex(int x, int y) {
    return (y * (WIDTH + 2)) + x;
  }

  private void addtoScreen(Entity en) {
    int x = en.getX();
    int y = en.getY();
    int w = en.getWidth();
    int h = en.getHeight();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        screen[xytoIndex(en.getX() + j, en.getY() + i)] = en.getImage()[(i * w) + j];
      }
    }
  }

  public void addEntity(Entity en) {
    entities.add(en);
  }


}
