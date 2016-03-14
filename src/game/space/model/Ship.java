package game.space.model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ship extends Sprite {

	private String craft = "test2new.png";
	private ArrayList <Sprite> missiles;
	private Missile altmissiles;
	private Image image;
	private Image shield;
	private String shieldImage = "shield.png";
	private int _shipBonus = 0;

	public Ship(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(shieldImage));
		shield = ii.getImage();
        missiles = new ArrayList<Sprite>();
        
        x = 400;
        y = 600;
	}
	
	public Image getImage() {
		return image;
	}
	
	public Image getShield() {
		return shield;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ArrayList<Sprite> getMissiles() {
		return missiles;
	}

	public void setMissiles(ArrayList<Sprite> missiles) {
		this.missiles = missiles;
	}
	
	 public int getShipBonus(){
     	return _shipBonus;
     }
     
     public void setShipBonus(int shipBonus){
     	_shipBonus = shipBonus;
     }
	
	

}
