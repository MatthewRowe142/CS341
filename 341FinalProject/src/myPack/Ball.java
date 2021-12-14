package myPack;


import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Ball extends GameObject{
	
	private int imageWidth;
	private Icon myImage;
	
	
	public Ball(int x, int y) {
		super(x, y);
		setVelocity(3);
		setDirection(Direction.NONE);
		myImage = new ImageIcon("images/ballRed.png");
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void move(Canvas c) {
		if(getDirection()==Direction.LEFT) {
			setX(getX()+getVelocity());
			if(getX()+imageWidth>c.getSize().getWidth()) {
				setDirection(Direction.RIGHT);
			}
		}else if(getDirection()==Direction.RIGHT) {
				setX(getX()-getVelocity());
				if(getX()+imageWidth<c.getSize().getWidth()) {
					setDirection(Direction.LEFT);
				}
			}
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
