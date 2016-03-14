package game.space.view;

import game.space.model.Board;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info  extends JFrame  implements ActionListener, MouseListener  {
	
	private Board _board;
	public JDialog _dialog;
	public JLabel info1;
	JLabel info2;
	JLabel info3;
	JLabel info4;

	
	public Info(Board board){
		
		super();								//gängige methode - aufruf des basis construktors.
		
		_dialog = new JDialog();
		setLayout(new GridLayout(3, 3 ,5 ,5));
		_board = board;							//hier die zuweisung ohne "this"
		addMouseListener(this);
		setUndecorated(true);
		setSize(500, 500);
   	 	setLocationRelativeTo(null);
   	 	setTitle("Menu");
   	 	setBackground(Color.GREEN);
   	 	setForeground(Color.YELLOW);
   	 	setVisible(false);
   	 	setAlwaysOnTop(true);
   	 info1 = new JLabel("Hit Esc to enter Menu");
   	 info1.setFont(new Font("Verdana",1,20));
   	 info1.setAlignmentX(45);
   	 JLabel info2 = new JLabel("Use mouse to control the ship");
   	 JLabel info3 = new JLabel("Leftmousebutton = Fire normal shot");
   	 JLabel info4 = new JLabel("Rightmousebutton = Fire super shot");
   	 
   	 
   	 JButton back = new JButton("zurück");
	 	back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             setVisible(false);
             _board.showMenu();
             
          }          
       });
	 	
	 	add(info1);
	 	add(info2);
	 	add(info3);
	 	add(info4);
	 	add(back);
	}
	
	
		
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
