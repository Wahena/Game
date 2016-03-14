package game.space.model;

import java.awt.Image;

import javax.swing.ImageIcon;

//eventuell ohne sprite erst bei collision...
public class Supermissile extends Sprite { 

    private double x, y;
    private Image image;
    boolean _visible;

    private final int BOARD_WIDTH = 1920;
    private final int Supermissile_SPEED = 9;

    public Supermissile(double x, double y) {

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("supermissile.png"));
        image = ii.getImage();
        _visible = true;
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
        return _visible;
    }

    public void move() {
        x += Supermissile_SPEED;
        if (x > BOARD_WIDTH)
            _visible = false;
    }
}
