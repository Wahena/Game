package game.space.controller;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.space.model.Board;
import game.space.model.Enemy;
import game.space.model.Sprite;

 

public class EnemyController {
	
	public Enemy _enemy;
	public Board _board;
	public double directionX = 6.4;
	public double directionY;
	public String enemyShip = "enemyship.png";
	public double enemySpeed = 6.4;
	
	
	public EnemyController(Enemy enemy, Board board){
		_enemy = enemy;
		_board = board;
		_enemy.setImage(createImage(enemyShip));
		
	}
	
	
	
	/* dynamische auswechslung des Raumschiffbildes */
	public Image createImage(String imageName){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imageName));
		
		return ii.getImage();
	}
	
	public void updateEnemy(){
		
		move();
		deleteEnemy();
		if (_enemy.getAll().size() <= 4){
			
			addEnemy();
			
			
			
		}
	}
	
	public void move(){
		ArrayList<Sprite> enemys = _enemy.getAll();
		
		for (Sprite sprite: enemys){
			
			double x = sprite.getX() - enemySpeed;
			sprite.setX(x);
//			if(x >=_board.screenWidth && x <= _board.screenWidth + enemySpeed){
//				sprite.life();
//			}
			
		}
	}
	
	public void deleteEnemy(){
		ArrayList<Sprite> enemys = _enemy.getAll();
		for(int i = 0; i < _enemy.getAll().size(); i++){	
			double x = enemys.get(i).getX();
			if (x <= -50){
				enemys.remove(i);
			}		
		}
	}
	
	public void addEnemy(){
	    	
	    	
	    	for(int i = 5; i<15;){
	    		_enemy.all.add(new Enemy(1800 + (i * i +150), (i * i+450 )));
	    		_enemy.all.add(new Enemy(1900 + (i * i +300), (i * i +350)));
	    		_enemy.all.add(new Enemy(1700 + (i * i +300), (i * i *i)));
	    		//_enemy.all.add(new Enemy(2100, 500));
	    		_enemy.all.add(new Enemy(2100 + (i * i +250), (i * i +50)));
	    		i+= 5;
	    	}
	    }
//**************************************************************************************************************
	//TODO alles in Controller verschieben!!
	
//	    public void act(double xCoords, double yCoords) {
//	    	
//	        if(xCoords <= -125){
//	        	
//	        	_enemy.die();
//	        	addEnemy();
//	        }
//	        int count;
//			if(xCoords == 800 && count == 2){
//	        	this.directionX = directionX * -1;
//	        	count = 0;
//	        }
//	        
//	        if(xCoords == 1650 && count == 1){
//	        	this.directionX = directionX * -1;
//	        	count ++;
//	        }
//	        
//	        if(xCoords >= 1920){
//	        	this.directionX = -2;
//	        	
//	        }
//	        
//	        if(y <= 0){
//	        	this.directionY =  1;
//	        }
//	        
//	        if (y == 1080){
//	        	this.directionY = directionY * -1;
//	        }
//	        int countmove;
//			//if (count %2 == 0){ // nur jeder 2te durchgang wird ausgeführt. halb so schnelle gegner
//	        if(countmove == 5900){
//	        	this.directionX = directionX * (-1);
//	        	//directionY = directionY * (-1);
//	        	countmove = 0;
//	        }
//	        
//	        if(countmove%300 == 0){
//	        	//direction = direction * (-1);
//	        	this.directionY = directionY * (-1);
//	        	//countmove = 0;
//	        }
//	        
//	        
//	        _enemy.x += directionX;
//	        _enemy.y += directionY;
//	        	//count = 1;
//	       // }
//	       // else{
//	        //	x += 0;
//	        //	y += 0;
//	        //	count ++;
//	        	
//	       // }	
//	        countmove ++;
//	    }
//****************************************************************************************************************
}
