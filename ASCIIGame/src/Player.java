import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements Entity, Controllable {
  private int x, y, width, height;
  private char[] image;
  private Renderer render;
  final JFrame frame;


  public Player(int x, int y, int width, int height, char[] image, Renderer render) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.image = image;
    this.render = render;

    render.addEntity(this);
    frame  = new JFrame();
    frame.setUndecorated(true);
    frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);


  }

  @Override
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public char[] getImage() {
    return image;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  public void setImage(char[] image) {
    this.image = image;
  }

  public void setHeight(int height) {
    this.height = height;
  }


  @Override
  public void handleInput() {
    synchronized (frame) {

      frame.addKeyListener(new KeyListener() {
        @Override
        public void keyPressed(KeyEvent e) {
          synchronized (frame) {
            char p = e.getKeyChar();
            handleKeys(p);
            frame.setVisible(false);
            frame.notify();
            frame.removeKeyListener(this);
          }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
      });
      frame.setVisible(true);
      try {
        frame.wait();
      } catch (InterruptedException e1) {
      }
    }

  }
  public void handleKeys(char key){
    switch (key){
      case 'a':
        moveLeft();
        break;
      case 'd':
        moveRight();
        break;
      case 'w':
        moveUp();
        break;
      case 's':
        moveDown();
        break;
      case 'q':
        System.exit(0);
        break;
    }
  }


  private void moveLeft(){
    if(x>0){
      x--;
    }
  }

  private void moveRight(){
    if(x<render.getWIDTH()){
      x++;
    }
  }

  private void moveUp(){
    if(y>0){
      y--;
    }
  }

  public void moveDown(){
    if(y<render.getHEIGHT()-1){
      y++;
    }
  }



}
