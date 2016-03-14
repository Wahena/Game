package game.space.view;

import sun.audio.*;
import game.space.controller.BoardController;
import game.space.controller.EnemyController;
import game.space.controller.Refree;
import game.space.controller.ShipController;
import game.space.controller.Sound;
import game.space.model.Board;
import game.space.model.Enemy;
import game.space.model.Ship;
import game.space.model.Upgrade;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
 












import game.space.model.Sprite;

public class Play extends JPanel implements MouseListener {
	
	public Background _background;
	public ShipController _shipController;
	public BoardController _boardController;
	public EnemyController _enemyController;
	public Ship _ship;
	public Enemy _enemy;
	public Board _board;
	public Upgrade _upgrade;
	public Refree _refree;
	public double mouseX;
	public double mouseY;
	public PointerInfo point;
	public boolean _play = false;
	public Image image;
	public Sound _sound;
	public Sound _shipSound;
	
	public Play(Board board){
		
		
		_board = board;	
    	setVisible(true);
    	addMouseListener(this);
    	setDoubleBuffered(true);
//		setVisible(false); wenn aktiviert reagieren die keyListener nicht mehr.
   	 	setFocusable(true);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					point = MouseInfo.getPointerInfo();
					mouseX = point.getLocation().getX();			// speichern der mausposition im moment des Menu
					mouseY = point.getLocation().getY();			//aufrufes mittels "Esc"-Taste					
	        		setPlay(false);
	        		_board.showMenu();									
	        	}
			}
		});
		
		/*key binding test____________________________________________________*/
		AbstractAction doSomething = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		        setPlay(false);
		        _board.showMenu();
		    }
		};
		getInputMap().put(KeyStroke.getKeyStroke("F2"),
		                            "doSomething");
		getActionMap().put("doSomething",
		                             doSomething);	
		/*____________________________________________________________________*/
		
		
	 	
		_background = new Background();
		_upgrade = new Upgrade(0,0);
		_refree = new Refree();
		_ship = new Ship();
		_ship.setVisible(true);
		_enemy = new Enemy(100,100);
		_sound = new Sound();
		_shipSound = new Sound();
		_enemyController = new EnemyController(_enemy, _board);
		_boardController = new BoardController(_board, _ship, _enemy, _refree, _sound, _shipSound);	
		_shipController = new ShipController(_ship, _boardController);
	}

	
	
	public void run() {		
		ActionListener counter = new ActionListener() 
		{
		    public void actionPerformed(ActionEvent ev)
		    {   
		    	if(getPlay()){		    		 
		    		//System.out.println("run " + _play + " in game loop");
		    		//System.out.println(System.currentTimeMillis() +" before update"); 
			        updateGame();
			       // System.out.println(System.currentTimeMillis() +" after update");
			        repaint();			        
		        }
		    }
		};
			new Timer(30, counter).start();		
	}		

	public void updateGame(){
		_background.move();
		_shipController.updateShip();
		_enemyController.updateEnemy();
		_boardController.updateBoard();
	}

	public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        try {
			_shipController.mousemove();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
        		drawBackground(g2d,_background);
        		
        		drawEnemy(g2d);
        		drawUpgrade(g2d);
        		_boardController.drawScore(g2d); // nach class play verlagern!
        		drawMissile(g2d);
        		drawShip(g2d);
        		drawShipUpgrades(g2d);
	}
	
	public void drawMissile(Graphics2D g2d) {
		ArrayList <Sprite> missiles = _ship.getMissiles(); 
			for (Sprite sprite: missiles ) {
					g2d.drawImage(sprite.getImage(), (int)sprite.getX(), (int)sprite.getY(), this);
			}
	}

	

	private void drawUpgrade(Graphics2D g2d) {
		if(_boardController._upgrade.getAll().size() > 0){
			ArrayList<Sprite> upgrades = _boardController._upgrade.getAll();
			for (Sprite spriteR: upgrades){
				g2d.drawImage(spriteR.getImage(), (int)spriteR.getX(), (int)spriteR.getY(), this);	
			}
		}
	}
	


	private void drawEnemy(Graphics2D g2d){
		ArrayList<Sprite> enemys = _enemy.getAll();
		for (Sprite spriteR: enemys){
			g2d.drawImage(spriteR.getImage(), (int)spriteR.getX(), (int)spriteR.getY(), this);	
		}
	}

	
 	public void drawShipUpgrades(Graphics g2d){
 		if (_ship.isVisible() && _ship.getShipBonus() == 1){
 			String s = "*"+ _shipController.getShieldCounter()+"*";
 			
 			g2d.setColor(new Color(96, 128, 255));
 			int fontSize = 14;
 	        g2d.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
 	        g2d.drawString(s, (int)_ship.getX()+55, (int)_ship.getY()-22);
 	        g2d.drawImage(_ship.getShield(), (int)_ship.getX() -50, (int)_ship.getY()-20, this);
 		}
 	}
	
	public void drawShip(Graphics g2d){
		if(_ship.isVisible()){
			g2d.drawImage(_ship.getImage(), (int)_ship.getX(), (int)_ship.getY(), this);
		}
		if(_ship.isDying()){
			
		}
		
	}
	
	public void drawBackground(Graphics g2d, Background background){
		g2d.drawImage(background.getBG(), background.getxScroll1() , 0 , this);
    	g2d.drawImage(background.getBG2(), background.getxScroll2() , 0 , this);
    	g2d.drawImage(background.getBG3(), background.getxScroll3() , 0 , this);
    	g2d.drawImage(background.getBG3(), background.getxScroll4() , 0 , this);
	}

	public Ship getShip() {
		return _ship;
	}

	public void setShip(Ship ship) {
		_ship = ship;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_shipController.mousePressed(e);
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setPlay(boolean play) {
		_play = play;
		
	}
	
	public boolean getPlay(){
		return _play;
	}

	public double getMouseX() {
		return mouseX;
	}

	public void setMouseX(double mouseX) {
		this.mouseX = mouseX;
	}

	public double getMouseY() {
		return mouseY;
	}

	public void setMouseY(double mouseY) {
		this.mouseY = mouseY;
	}
}