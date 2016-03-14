package game.space.model;

import game.space.controller.Sound;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {
	
	public Sound enemySound;
	
	public Image image;
	public String enemyship = "enemyship.png";
	public ArrayList <Sprite> all;
	
	public Enemy(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(enemyship));  
        image = ii.getImage();
	
	
	}
    public Enemy(int xCords, int yCords) {
    	
    	enemySound = new Sound();
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(enemyship));  
            image = ii.getImage();
    	
    	all = new ArrayList();
    	
      x = xCords;
      y = yCords;
    }

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ArrayList<Sprite> getAll() {
		return all;
	}

	public void setAll(ArrayList<Sprite> all) {
		this.all = all;
	}
}
