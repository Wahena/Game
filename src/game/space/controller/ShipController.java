package game.space.controller;

import game.space.controller.Sound;
import game.space.model.Board;
import game.space.model.Missile;
import game.space.model.Ship;
import game.space.model.Sprite;
import game.space.model.Supermissile;
import game.space.view.Background;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class ShipController implements ActionListener , MouseListener {
	
	/*Image gefäss für die bilder des schiffes*/
	public Image shildImage;
	public Image deathImage1;
	public Image deathImage2;
	public Image deathImage3;
	public Image deathImage4;
	
	/*zuweisung der Bilddateinamen*/
	public String shildShip = "spaceshipShield.png";
	public String shipImage = "spaceship.png";
	public String death1 = "death1.png";
	public String death2 = "death2.png";
	public String death3 = "death3.png";
	public String death4 = "death4.png";
	
	/*steuerung des cursor bzw. des schiffes*/
	private int mouseXold = 500;
    private int mouseYold = 500;
    private int movex;
    private int movey;
    private int shieldCounter = 300;
	
    
	private final int CRAFT_SIZE = 112;
	
	public Ship _ship;
	public BoardController _board;
	public Sound sound;
	
	public ShipController(Ship ship, BoardController board) {
		_ship = ship;
		_board = board;
	}
	
	/* dynamische auswechslung des Raumschiffbildes */
	public Image createImage(String imageName){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imageName));
		return ii.getImage();
	}
		
	/* update des schiffes mögliche veränderungen werden erfasst und notwendige änderungen vorgenommen*/
	public void updateShip(){
		
		/*im fall das schiff einen schild erhält*/
		
		/*im fall das schiff zerstört wird auswechslung der anzuzeigenden bilder im richtigen abstand*/
		//Integer _shipExp = _ship.getExp();
	
		if(_ship.isDying()){
//			System.out.println(_shipExp);
//    		if (_shipExp > 150){	
//    			_ship.setImage(createImage(death1));
//    		}
//    		else if (_shipExp > 120 && _shipExp <= 150){
//    			_ship.setImage(createImage(death1));		      	
//    		}
//    		else if (_shipExp > 90 && _shipExp <= 120){
//    			_ship.setImage(createImage(death2));		      	
//    		}
//    		else if (_shipExp > 60 && _shipExp <= 90){
//    			_ship.setImage(createImage(death3));		      	
//    		}
//    		else if (_shipExp > 30 && _shipExp <= 60){
//    			_ship.setImage(createImage(death4));		      
//    		}
//    		else if (_shipExp > 1 && _shipExp <= 30){
//    			_ship.setImage(createImage(death4));		      	
//    		}
//    		if(_shipExp > 0){
//    			_ship.setExp(_shipExp-1);
//    		}   		
		}
		
		/* bild des normalen schiffes wird zugwiesen*/
		if(_ship.isVisible()&& !_ship.isDying()){
			
			if(_ship.getShipBonus() == 3){
				System.out.println("effekt 3 triggered");
				_ship.setShipBonus(0);
			}
			else if(_ship.getShipBonus() == 2){
				System.out.println("effekt 2 triggered");
				_ship.setShipBonus(0);
			}
			else if(_ship.getShipBonus() == 1 && shieldCounter >= 1){
//				if (shieldCounter == 300){
//					//setShieldShipImage();
//				}
				shieldCounter--;				
				System.out.println("effekt 1 triggered  " +shieldCounter);
				
				if(shieldCounter <= 0){
					//_ship.setImage(createImage(shipImage));
					setShieldCounter(300);
					_ship.setShipBonus(0);
				}
				
				
			}
			
		else {
			_ship.setImage(createImage(shipImage));
		}
		}
		
		
		
		
		missileMove();
	}
	
public void mousemove() throws AWTException{ //throws AWTException{
    	
    	PointerInfo point = MouseInfo.getPointerInfo();
    	
    	if((int) point.getLocation().getX() < mouseXold){	
    		int f = mouseXold - ((int)point.getLocation().getX());
    		movex = (int) (movex - (f*0.75));
    	}
    	
    	if((int) point.getLocation().getX()> mouseXold){
    		int f = ((int)point.getLocation().getX()) - mouseXold;
    		long xx = Math.round((f*0.75 ))<1?1:Math.round((f*0.75 )); //Tärtiärer Operator 
    		movex = (int) ((int) (movex + xx ));	
    	}
    	
    	mouseXold = movex;
    	
    	if((int) point.getLocation().getY() < mouseYold){
    		int f = mouseYold - ((int)point.getLocation().getY());
    		movey = (int) ((int) (movey - (f*0.75)));    		
    	}
    	else if((int) point.getLocation().getY()> mouseYold){	
    		int f = ((int)point.getLocation().getY()) - mouseYold;
    		long xx = Math.round((f*0.75 ))<1?1:Math.round((f*0.75 ));
    		movey = (int) ((int) (movey + xx ));
    	}
    	mouseYold = movey;
    	
    	point.getLocation().setLocation(movex, movey);
    	Robot robot = new Robot();
        robot.mouseMove(movex, movey);       
    	
    	_ship.setX(movex);
    	_ship.setY(movey);
    }
		
	public void missileMove(){
		ArrayList <Sprite> missiles = _ship.getMissiles(); 
		for (Sprite sprite: missiles ) {
			sprite.move();
		}
	}
	
	public void setShieldShipImage(){
		_ship.setImage(createImage(shildShip));		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		int button = m.getButton();
    	
    	if (button ==1){
    		fire();
    		if(_board.is_soundEfx()){
    			_board.playShot();
    		}
    		
    	}
    	else if(button ==3){
    		superfire();
    		if(_board.is_soundEfx()){
    			_board.playBomb();
    		}
    		
    	}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void superfire() {
		_ship.getMissiles().add(new Supermissile(_ship.getX() + CRAFT_SIZE, _ship.getY() + CRAFT_SIZE / 3));
	}

	private void fire() {
		_ship.getMissiles().add(new Missile(_ship.getX() + CRAFT_SIZE -9, _ship.getY() + (CRAFT_SIZE/3) +8));	
	
	}

	public int getShieldCounter() {
		return shieldCounter;
	}

	public void setShieldCounter(int shieldCounter) {
		this.shieldCounter = shieldCounter;
	}
}
