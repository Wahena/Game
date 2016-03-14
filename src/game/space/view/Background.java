package game.space.view;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Background{
	
	private int xScroll3 = 0;
	private int xScroll4 = 1920;
	private int xScroll1 = 0;
	private int xScroll2 = 1920;
	
	private Image image;
	private int scrollcount = 2;
	private String background = "background.png";
	private String background21 = "background21.png";
	private String backgroundAlt = "backgroundAlt.png";
	
	public Background(){
	}
	
	public void move() {
	
		if (scrollcount%2 == 0){
			xScroll1--;
			xScroll2--;
		}
		
		xScroll3--;
		xScroll4--;
			//scrollcount++;
		
		if(xScroll1 == -1920){
			xScroll1 = 1920;
		}
		if(xScroll2 == -1920){
			xScroll2 = 1920;
		}
		if(xScroll3 == -1920){
			xScroll3 =1920;
		}
		if(xScroll4 == -1920){
			xScroll4 = 1920;
		}
		scrollcount++;
	}
	
	public Image getBG() {
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(background));
        image = ii.getImage();
        
        return image;
    }
    
    public Image getBG2() {
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(background21));
        image = ii.getImage();
        
        return image;
    }
    
    public Image getBG3() {
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(backgroundAlt));
        image = ii.getImage();
        
        return image;
    }

	public int getxScroll3() {
		return xScroll3;
	}

	public void setxScroll3(int xScroll3) {
		this.xScroll3 = xScroll3;
	}

	public int getxScroll4() {
		return xScroll4;
	}

	public void setxScroll4(int xScroll4) {
		this.xScroll4 = xScroll4;
	}

	public int getxScroll1() {
		return xScroll1;
	}

	public void setxScroll1(int xScroll1) {
		this.xScroll1 = xScroll1;
	}

	public int getxScroll2() {
		return xScroll2;
	}

	public void setxScroll2(int xScroll2) {
		this.xScroll2 = xScroll2;
	}
}
