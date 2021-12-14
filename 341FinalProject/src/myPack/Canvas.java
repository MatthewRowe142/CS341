package myPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Canvas extends JComponent implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame();
	private Timer gameLoopTimer;
	private List <GameObject> gameObjectList;
	Canvas() {
		gameObjectList = new LinkedList<GameObject>();
		frame = new JFrame ("FinalProject Experiment");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		frame.setVisible(true);
		
				
		
	}
	
	public synchronized void addGameObject(GameObject gObject) {
		gameObjectList.add(gObject);
	}
	
	public synchronized void paint (Graphics g) {
		for (GameObject gObject : gameObjectList) {
			gObject.draw(this, g);
		}
	}
	
	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		
		for(GameObject gameObject: gameObjectList ) {
			setBorder(BorderFactory.createLineBorder(Color.red));
			gameObject.move(this);
		}
		repaint();
		// TODO Auto-generated method stub
		
	}
}
