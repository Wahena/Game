package game.space.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Sprite {

        public boolean visible;
       
       
        public double x =1800;
        public double y = 500;
        protected boolean dying;
        public Image image;
                
    	public Sprite() {
            visible = true;
        }
    	
    	public void life(){
    		visible = true;
    	}

        public void die() {
            visible = false;
        }

        public boolean isVisible() {
            return visible;
        }
        
       
        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public Image getImage() {
            return image;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }
        public double getY() {
            return y;
        }

        public double getX() {
            return x;
        }

        public void setDying(boolean dying) {
            this.dying = dying;
        }
//        
//        public int getEffekt(){
//    		return this.effekt;
//    	}
//    	
//    	public void setEffekt(int effekt){
//    		this.effekt = effekt;
//    	}
//    	
//    	public Image getImageDeath() {
//        	ImageIcon ii = new ImageIcon(this.getClass().getResource(enemydeath4));
//            image = ii.getImage();
//        	
//        	return image;
//        }
//    	
//    	public int getExp() {
//    		return exp;
//    	}
//
//
//    	public void setExp(int exp) {
//    		this.exp = exp;
//    	}

        public boolean isDying() {
            return this.dying;
        }
        
        public void move() {
           this.x = x -2;
           if (this.x > 1920 || this.x < 0){
        	   setVisible(false);
           }
        }
        
        
        
//        public void explodeEnemy(Graphics g){
//        	//super.paint(g);
//        	
//        	 Graphics2D g2d = (Graphics2D)g;
//        	
//        	
//        		for(int i = 0; i < enemyExpMax; i++){
////	        		if (enemyExp > 1500){
////	    	        	g2d.drawImage(getImageDeath(enemydeath1), getX(), getY(), this);
////	    		      	enemyExp--;
////	        		}
////	        		
////	        		else if (enemyExp > 1200 && enemyExp <= 1500){
////	    	        	g2d.drawImage(getImageDeath(enemydeath2), getX(), getY(), this);
////	    		      	enemyExp--;
////	        		}
////	        		else if (enemyExp > 900 && enemyExp <= 1200){
////	    	        	g2d.drawImage(getImageDeath(enemydeath3), getX(), getY(), this);		// ZU LANGE EXPLOSIONS ANIMATION
////	    		      	enemyExp--;
////	        		}
////	        		else if (enemyExp > 600 && enemyExp <= 900){
////	    	        	g2d.drawImage(getImageDeath(enemydeath3), getX(), getY(), this);
////	    		      	enemyExp--;
////	        		}
////	        		else if (enemyExp > 300 && enemyExp <= 600){
////	    	        	g2d.drawImage(getImageDeath(enemydeath4), getX(), getY(), this);
////	    		      //	exp--;
////	        		}
////	        		else if (enemyExp > 1 && enemyExp <= 300){
//	        			g2d.drawImage(getImageDeath(), getX(), getY(), this);
//	    		      	enemyExp--;
////	        		}
//	        		enemyExp--;
//        		}
//        		enemyExp = 180;
//        	
//        }

	
}