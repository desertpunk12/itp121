import javax.swing.*;

public class Home {
    private String location;
    private int size;
    private String color;
    private String shape;

    public Home(String location, int size, String color, String shape) {
        this.location = location;
        this.size = size;
        this.color = color;
        this.shape = shape;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size>0) {
            this.size = size;
        }else{
            System.out.println("Invalid Size");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
