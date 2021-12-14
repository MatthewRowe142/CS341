package myPack;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Type_B_GameObject extends GameObject implements KeyListener {
	private LinkedList<Icon>imageList = new LinkedList<Icon>();
	Type_C_GameObject gameObjectC;
	public Type_B_GameObject(int x, int y, Type_C_GameObject gameObjectC) {
		super(x, y);
		this.gameObjectC = gameObjectC;
        
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("imgs/Type_B_Up.png"));
		imageList.add(new ImageIcon("imgs/Type_B_Down.png"));
		imageList.add(new ImageIcon("imgs/Type_B_Left.png"));
		imageList.add(new ImageIcon("imgs/Type_B_Right.png"));

	}

	public void move(Canvas c) {
		this.c = c;
		Icon icon = getCurrentImage();

		int  iconHeight   = icon.getIconHeight();
		int  iconWidth    = icon.getIconWidth();
		int  canvasHeight = (int)c.getSize().getHeight();
		int  canvasWidth  = (int)c.getSize().getWidth();

		//MOVE BLUE GAME OBJECT
		switch (getDirection()) {
		case Direction.UP:
			setY(getY() - getVelocity());
			if (getY() < 0) {
				setY(0);
				newDir();
			}
			break;
		case Direction.DOWN:
			setY(getY() + getVelocity());
			if (getY() + iconHeight > canvasHeight) {
				setY((int)(canvasHeight - iconHeight));
				newDir();
			}
			break;
		case Direction.LEFT:
			setX(getX() + getVelocity());
			if (getX() + iconWidth > canvasWidth) {
				setX((int)(canvasWidth - iconWidth));
				newDir();
			}
			break;
		case Direction.RIGHT:
			setX(getX() - getVelocity());
			if (getX() < 0) {
				setX(0);
				newDir();
			}
			break;
		default:
			break;
		}

	}

	private Icon getCurrentImage() {
		return myImage;
	}

	//SPECIFY THE IMAGE TO DISPLAY
	//   USED FOR ANIMATION
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.UP:
			myImage = imageList.get(0);
			break;
		case Direction.DOWN:
			myImage = imageList.get(1);
			break;
		case Direction.LEFT:
			myImage = imageList.get(2);
			break;
		case Direction.RIGHT:
			myImage = imageList.get(3);
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			setDirection(Direction.UP);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setDirection(Direction.DOWN);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setDirection(Direction.LEFT);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setDirection(Direction.RIGHT);
		}
	    if (e.getKeyCode() == KeyEvent.VK_TAB) {
	    	c.removeKeyListener(this);
	    	setDirection(1);
	    	c.addKeyListener(gameObjectC);
	    }
	    setImage();
	}
	public void newDir() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		int rem = getDirection();
		list.remove(list.indexOf(rem));
		
		Random rand = new Random();
		int randI = rand.nextInt(3);
		setDirection(list.get(randI));
		setImage();
		
	}

}

