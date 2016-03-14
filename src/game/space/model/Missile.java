package game.space.model;

import java.awt.Image;

import javax.swing.ImageIcon;

//eventuell ohne sprite erst bei collision...
public class Missile extends Sprite { 

    private double x, y;
    private Image image;
    boolean visible;
    public String shot = "shot.png";

    public static final int BOARD_WIDTH = 1920;
    public static final double MISSILE_SPEED = 16.9;

    public Missile(double x, double y) {

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource(shot));
        
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
       
    }


    public Image getImage() {
        return image;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
        x += MISSILE_SPEED;
        //y += 1;
        if (x > BOARD_WIDTH)
            visible = false;
    }
}
