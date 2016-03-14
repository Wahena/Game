package game.space.view;

import game.space.model.Board;
import game.space.view.*;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import org.omg.CORBA._PolicyStub;

public class Menu extends JFrame  implements ActionListener, MouseListener {
	
	private Board _board; 						// mit "_" am anfang kann "this" weggelassen werden.
	private JButton start;
	private JButton start1;
	private Play _play;
	JButton neuStart;
	JButton ende;
	JButton option;
	JButton info;
	
	public Menu(Board board){
		
		super();								//gängige methode - aufruf des basis construktors.
		
		new JDialog();
		setLayout(new GridLayout(3, 3 ,5,5));
		_board = board;							//hier die zuweisung ohne "this"
		//_play = new Play(_board);
		addMouseListener(this);
		setUndecorated(true);
		setSize(500, 500);
   	 	setLocationRelativeTo(null);
   	 	setTitle("Menu");
   	 	setVisible(false);
   	 	setAlwaysOnTop(true);
   	 	
   	 	start = new JButton("Spiel starten");
   	 	//start.setSize(70, 70);
   	 	Dimension di = new Dimension(40,40);
   	 	start.setPreferredSize(di);
   	 	start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                _board.showPlay();
                start.setEnabled(false);
                start1.setEnabled(true);
//                spiel anzeigen
             }          
          });
   	 	start1 = new JButton("Spiel fortsetzen");
   	 	start1.setEnabled(false);
   	 	start1.setSize(70, 70);
   	 	start1.addActionListener(new ActionListener() {
   	 		public void actionPerformed(ActionEvent e) {
   	 			setVisible(false);
   	 			_board._play.setPlay(true);
   	 			_board.setCursor(getToolkit().createCustomCursor(new ImageIcon("").getImage(), new Point(0, 0), "No Cursor"));
   	 			try {
					Robot robot = new Robot();
					//System.out.println("robot mouseX = "+_play.getMouseX() +" mouseY = " + _play.getMouseY());
					robot.mouseMove((int)_board._play.getMouseX(), (int) _board._play.getMouseY());
					//System.out.println("robot mouseX = "+_play.getMouseX() +" mouseY = " + _play.getMouseY());
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//   	 		System.out.println("robot mouseX = "+_play.getMouseX() +" mouseY = " + _play.getMouseY());
   	 		}          
   	 	});
   	 	neuStart = new JButton("Spiel neustarten");
   	 	neuStart.setSize(70, 70);
   	 	neuStart.addActionListener(new ActionListener() {
   	 		public void actionPerformed(ActionEvent e) {
   	 			setVisible(false);
   	 			_board._play._sound.stopBg();
   	 			board.dispose();
   	 			new Board();
   	 		}          
   	 	});
   	 	
   	 	ende = new JButton("Spiel beenden");
   	 	ende.setSize(70, 70);
   	 	ende.addActionListener(new ActionListener() {
   	 		public void actionPerformed(ActionEvent e) {
   	 			System.exit(1);
   	 		}          
   	 	});
   	 	
//   	 	start.setSize(20, 40);
//   	 	start.setLocation(10, 10);
   	 	
   	 	option = new JButton("Optionen");
	   	option.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             setVisible(false);
	             _board.showOption();
	          }          
	       });
	   	
	   info = new JButton("Info");
	   	info.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             setVisible(false);
	             _board.showInfo();
	          }          
	       });
   	 	
	 	add(start);
	 	add(start1);
	 	add(neuStart);
	 	add(ende);
	 	add(option);
	 	add(info);
   	 
	}

		
	@Override
	public void mouseClicked(MouseEvent m) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		
		//this.setVisible(false);
		
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
