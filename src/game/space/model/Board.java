package game.space.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import game.space.*;
import game.space.controller.ShipController;
import game.space.controller.Sound;
import game.space.view.*;

public class Board extends JFrame{
	
	public int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	public int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	public Menu _menu ;
	public Option _option;
	public Info _info;
	public Play _play;
	public Gameover _gameover;
	public Sound sound; //hier oder im controller ansprechen von menu aus betreff neustart
	public Sound shipSound;
		
	public Board(){
		
		_menu = new Menu(this);
		_option = new Option(this);
		_info = new Info(this);
		_play = new Play(this);
		_gameover = new Gameover();
    	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		
//		setSize(800,800); für test zwecke
//    	setExtendedState(Frame.MAXIMIZED_BOTH); //erzeugt auf Ubuntu fehlerhafte ausgabe.
		
    	setSize(screenWidth, screenHeight);
    	setLocationRelativeTo(null);
    	setTitle("Shoot the Lakers");
    	setResizable(false);
    	
    	add(_play);
    	
    	setVisible(true);   	
    	_menu.setVisible(true);
	}
	
	public void showMenu(){
		setCursor(Cursor.getDefaultCursor());
		_menu.setVisible(true);
	}
	
	public void showOption(){
		_option.setVisible(true);
	}
	
	public void showInfo(){
		_info.setVisible(true);
	}

	public void showGameover(){
		_gameover.setVisible(true);
	}
	
	public void showPlay(){
		
		//System.out.println("Play");
		_play.setPlay(true);
		_play.run();
		_play.setVisible(true);	
		setCursor(getToolkit().createCustomCursor(new ImageIcon("").getImage(), new Point(0, 0), "No Cursor"));	
	}	
}
