package myPack;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {
	private LinkedList<Icon>imageList = new LinkedList<Icon>();
	Type_B_GameObject gameObjectB;
	public Type_A_GameObject(int x, int y, Type_B_GameObject gameObjectB) {
		super(x, y);
		this.gameObjectB = gameObjectB;
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("imgs/Type_A_Up.png"));
		imageList.add(new ImageIcon("imgs/Type_A_Down.png"));
		imageList.add(new ImageIcon("imgs/Type_A_Left.png"));
		imageList.add(new ImageIcon("imgs/Type_A_Right.png"));

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
	    if (e.getKeyCode() == KeyEvent.VK_TAB) {
	    	c.removeKeyListener(this);
	    	setDirection(1);
	    	c.addKeyListener(gameObjectB);
	    }
	    setImage();
	}

	public void newDir() {
		
		setDirection(4-getDirection());
		setImage();
		
	}

}

