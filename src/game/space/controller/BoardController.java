package game.space.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import game.space.model.Board;
import game.space.model.Enemy;
import game.space.model.Missile;
import game.space.model.Ship;
import game.space.model.Sprite;
import game.space.model.Supermissile;
import game.space.model.Upgrade;

public class BoardController{
	
	public Board _board;
	public Ship _ship;
	public Enemy _enemy;
	public Refree _refree;
	public Sound _sound;
	public Sound _shipSound;
	public Upgrade _upgrade;
	public int score = 0;
	private boolean _soundEfx = false;

	public BoardController(Board board, Ship ship, Enemy enemy, Refree refree, Sound sound, Sound shipSound){
		_board = board;
		_ship = ship;
		_enemy = enemy;
		_refree = refree;
		
		
		_shipSound = shipSound; //new Sound();
		_shipSound.loadSound();
		_sound = sound;//new Sound();
		_sound.loadSound();
		//_sound.loopBg();
		_upgrade = new Upgrade(0, 0);
	}
	
	public void updateBoard(){
		collisionCheck();	
		//drawScore(Graphics 2D g);
	}
	
	public void drawScore(Graphics2D g){
    	
        String s;
        int fontSize = 40;
        
        g.setColor(new Color(255, 0, 0));
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        s = "Score: " + getScore();
        g.drawString(s, 1900 / 2 + 96, 1000 + 16);
    }
	
//	public void ende(Graphics2D g){
//		 Graphics2D g2d = (Graphics2D)g;
//	    	
//		 ImageIcon ii = new ImageIcon(this.getClass().getResource(ende));
//	     image = ii.getImage();
//	     
//	     g2d.drawImage(image, 0, 0, this);
//		 	
//	       
//	    }
	    
//		public void bomb(Graphics2D g){
//		    	
//	        String s;
	//
//	        int fontSize = 25;
//			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize ));
//	        g.setColor(new Color(255, 0, 0));
//	        s = "Bombs: " + anzahlBomb;
//	        g.drawString(s, 1000 / 2 + 96, 1000 + 16);
//	    }
		
//		public void bonus(Graphics2D g){
//			String s;
//			
//			g.setColor(new Color(96, 128, 255));
//	        if(bonus == null){
//			s ="";
//	        }
//	        else{
//	        s = bonus;
//	        }
//	        g.drawString(s, ship.getX()+75, ship.getY()-5);
//		}
	
	public void playShot(){
		_shipSound.playShot();
	}
	public void playBomb(){
		_shipSound.playBomb();
	}
	
	public void collisionCheck(){
		upgradeCollision();
		ArrayList<Sprite> enemys = _enemy.getAll();
		ArrayList<Sprite> missiles = _ship.getMissiles();
		
		
		for (int i = 0; i < enemys.size();i++){			
			double enemyX = enemys.get(i).getX();
			double enemyY = enemys.get(i).getY();
			//Object enemyClass = sprite.getClass();
			
			if(_ship.getShipBonus() != 1 && _refree.crashplayer(_ship.getX(), _ship.getY(), enemys.get(i).getX(), enemys.get(i).getY())){
				_ship.setVisible(false);
				System.out.println("SHIP DIE");
			}
			
			for (int j = 0; j < missiles.size();j++){
				double shotX = missiles.get(j).getX();
				double shotY = missiles.get(j).getY();
				//Object shotClass = sprite.getClass();
				if(missiles.get(j).isVisible()){
					if(_refree.crash(enemyX, enemyY, shotX, shotY)){
						//sprite.die();
						enemys.remove(i);
						score++;
						if(score %2 == 0){
							_upgrade.addUpgrade(shotX, shotY);
							System.out.println("add Upgrade");
						}
						//Sound test = new Sound(); // bild ruckelt?!?
						if(is_soundEfx()){
							_sound.playBomb();
						}
						if(missiles.get(j) instanceof Missile){
							missiles.remove(j);		
						}
					}
				}
			}	
		}
		
	}
	
	public int upgradeCollision(){
		ArrayList <Upgrade> upgrades = _upgrade.getAll();
		int result = 0;
		for(int k = 0; k < upgrades.size(); k++){
			double upgradeX = upgrades.get(k).getX();
			double upgradeY = upgrades.get(k).getY();
			if(upgrades.get(k).isVisible() && _ship.isVisible()){
				if(_refree.upgradeCrash(_ship.getX(), _ship.getY(), upgradeX, upgradeY)){
					_ship.setShipBonus((upgrades.get(k).getEffekt()));
					System.out.println("ugrade collision detected");
					upgrades.remove(k);
				}
			}
		}
		
		return result;
		
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	

	public boolean is_soundEfx() {
		return _soundEfx;
	}

	public void set_soundEfx(boolean soundEfx) {
		_soundEfx = soundEfx;
	}

	
}
