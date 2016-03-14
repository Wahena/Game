package game.space.view;

import game.space.controller.Sound;
import game.space.model.Board;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Option extends JFrame implements ActionListener , MouseListener{
	public Board _board;
	//public Sound sound;
	public Option(Board board){
		
		_board = board;
	//	sound = new Sound();
		
		new JDialog();
		setLayout(new GridLayout(4, 4));
		setUndecorated(true);
		addMouseListener(this);
		setSize(500, 500);
   	 	setLocationRelativeTo(null);
   	 	setTitle("Optionen");
   	 	setBackground(Color.RED);
   	 	setVisible(false);
   	 	setAlwaysOnTop(true);
   	 	
   	 JButton back = new JButton("zurück");
	 	back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          setVisible(false);
          _board.showMenu();
          
       }          
    });
	 	JButton soundOff = new JButton("Sound aus");
	 	soundOff.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			_board._play._boardController._sound.stopBg();
	 			
	 		}          
	 	});
	 	JButton soundOn = new JButton("Sound ein");
	 	soundOn.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			_board._play._boardController._sound.loopBg();
	 			
	 		}          
	 	});
	 	
	 	JButton soundDown = new JButton("Sound leiser");
	 	soundDown.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			_board._play._boardController._sound.bgVolumeDown();
	 			
	 		}          
	 	});
	 	
	 	JButton soundUp = new JButton("Sound lauter");
	 	soundUp.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			_board._play._boardController._sound.bgVolumeUp();
	 			
	 		}          
	 	});

	 	
	 	JButton soundEfxOff = new JButton("Soundeffekte aus");
	 	soundEfxOff.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			_board._play._boardController.set_soundEfx(false);
	 			
	 		}          
	 	});
	 	JButton soundEfxOn = new JButton("Soundeffekte ein");
	 	soundEfxOn.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			_board._play._boardController.set_soundEfx(true);
	 			
	 		}          
	 	});
	 	
	 	add(back);
	 	add(soundOn);
	 	add(soundOff);
	 	add(soundEfxOn);
	 	add(soundEfxOff);
	 	add(soundDown);
	 	add(soundUp);
	}

	
	@Override
	public void mouseClicked(MouseEvent m) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
