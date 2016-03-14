package game.space.controller;

public class Refree{
	
	//Anzeige d = new Anzeige();
	
	public Refree() {
	}
	
	public boolean crash(double enemyX, double enemyY, double shotX, double shotY){
		boolean crash = false;
		if (shotX >= enemyX && 
			shotX <= enemyX + 70 &&
			shotY >= enemyY &&
			shotY <= enemyY + 60){
			crash = true; 
		}
		
		return crash;
		
	}
	
	public boolean upgradeCrash(double shipX, double shipY, double upgrX, double upgrY) {
		boolean crash = false;
		if (upgrX >= shipX && 
			upgrX <= shipX+ 150 &&
			upgrY >= shipY &&
			upgrY <= shipY  + 50){
				crash = true; 
		}
		
		return crash;
	}
	
	
	public boolean bombcrash(int enemyX, int enemyY, int bombX, int bombY){
		boolean crash = false;
		if (	bombX + 10 >= enemyX      	&& 
				bombX + 10 <= enemyX + 75 	&&
				bombY + 10 >= enemyY 	 	&&			//erster fall enemy von oben rechts
				bombY + 10 <= enemyY + 50  
				
//				||
//				
//				enemyX +75 >= bombX       	&&
//				enemyX +75 <= bombX + 21 	&&
//				enemyY +50 >= bombY + 21 	&&		//zweiter fall enemy von oben links
//				enemyY +50 <= bombY + 21 
//				
//				||
//				
//				enemyX >= bombX 			&&
//				enemyX <= bombX + 21     	&&
//				enemyY >= bombY + 21 		&&		//dritter fall enemy von unten rechts
//				enemyY <= bombY + 21 
					
					//evt. vierter fall enemy von unten links nicht nötig...
					){
				crash = true;
				
			}
		return crash;
		
	}
	
	//TODO pixelgenaue kollisionsabfrage implementieren
	public boolean crashplayer(double playerX, double playerY, double enemyX, double enemyY){
		boolean crash = false;
		if (enemyX >= playerX && 
			enemyX <= playerX + 149 &&
			enemyY + 50 >= playerY + 40 &&			//erster fall enemy von oben rechts
			enemyY + 50 <= playerY + 75 
			
			||
			
			enemyX +75 >= playerX &&
			enemyX +75 <= playerX + 149 &&
			enemyY +50 >= playerY + 40 &&		//zweiter fall enemy von oben links
			enemyY +50 <= playerY + 75 
			
			||
			
			enemyX >= playerX &&
			enemyX <= playerX + 149 &&
			enemyY >= playerY + 40 &&		//dritter fall enemy von unten rechts
			enemyY <= playerY + 75 
				
				//evt. vierter fall enemy von unten links nicht nötig...
				){
			crash = true;
			
		}
		return crash;	
		//coordinaten vergleichen
			
	}

}
