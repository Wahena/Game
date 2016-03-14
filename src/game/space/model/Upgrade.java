package game.space.model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.space.*;

public class Upgrade extends Sprite {

	private String upgrade1 = "/ug1.png";
	private String upgrade2 = "/ug2.png";
	private String upgrade3 = "/ug3.png";
	private int timer = 15;
//	private boolean active;
	private int effekt;
	private Image image;
	private int upgradeX;
	private int upgradeY;
	boolean visible;
	
	private ArrayList <Sprite> all;// = new ArrayList();
	
	
	public Upgrade(double shotX, double shotY){
	
		all = new ArrayList();
		this.x = shotX;
		this.y = shotY;
		
		//int i = (int) (Math.random()*3+1);
		int i = 1;
		System.out.println(i);
		switch (i) {
		case 1:
//			ImageIcon ii = new ImageIcon(this.getClass().getResource(upgrade1));
//	    	image = ii.getImage();
	    	
	    	visible = true;
	    	ImageIcon ii = new ImageIcon(this.getClass().getResource(upgrade1));
	        image = ii.getImage();	
	        this.setImage(getImageUg1());
	    	this.setEffekt(1);
			break;
			
		case 2:
//			ImageIcon iii = new ImageIcon(this.getClass().getResource(upgrade2));
//	    	image = iii.getImage();
//		
	    	visible = true;
	    	ImageIcon ii2 = new ImageIcon(this.getClass().getResource(upgrade2));
	        image = ii2.getImage();	
	        this.setImage(getImageUg2());
	    	this.setEffekt(2);
			break;
			
		case 3:
//			ImageIcon iiii = new ImageIcon(this.getClass().getResource(upgrade3));
//	    	image = iiii.getImage();
			
	    	visible = true;
	    	ImageIcon ii3 = new ImageIcon(this.getClass().getResource(upgrade3));
	        image = ii3.getImage();	
	        this.setImage(getImageUg3());
	    	this.setEffekt(3);
	    	break;
	    }
		
	}
	
	public void addUpgrade(double xCord, double yCord){		
		all.add(new Upgrade(xCord,yCord));		
	}
	
	public Image getImageUg1() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(upgrade1));
        image = ii.getImage();
    	
    	return image;
    }
	
	public Image getImageUg2() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(upgrade2));
        image = ii.getImage();
    	
    	return image;
    }
	
	public Image getImageUg3() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(upgrade3));
        image = ii.getImage();
    	
    	return image;
    }
//	
//	public void setImage(Image image){
//		this.image = image;
//	}
	
//	public int getEffekt(){
//		return this.effekt;
//	}
//	
//	public void setEffekt(int effekt){
//		this.effekt = effekt;
//	}
	
	 public ArrayList getAll() {
	        return all;
	    }

	public int getEffekt() {
		return effekt;
	}

	public void setEffekt(int effekt) {
		this.effekt = effekt;
	}
	
}
