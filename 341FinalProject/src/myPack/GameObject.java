package myPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;

public abstract class GameObject {
	public abstract void move(Canvas c);
	private int x;
	private int y;
	private int velocity;
	private int direction;
	protected Icon myImage;
	protected Canvas c;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 1;		
	}
	public void draw(JComponent c, Graphics g) {
		if(!(this.c==(null))) {
			if(this.c.getKeyListeners()[0]==this) {
				Color col = new Color(255,0,0);
				g.setColor(col);
				
				g.drawRect(getX(), getY(), 160, 139);
			}
		}
		myImage.paintIcon(c, g, x, y);
	}

}
