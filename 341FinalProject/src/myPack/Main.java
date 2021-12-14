package myPack;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main{

	public static void main(String[] args) {


		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		Type_D_GameObject gObjectD = new Type_D_GameObject(0,0);
		gObjectD.setDirection(2);
		gObjectD.setImage();
		gObjectD.setVelocity(5);
		Type_C_GameObject gObjectC = new Type_C_GameObject(500,500,gObjectD);
		gObjectC.setDirection(2);
		gObjectC.setImage();
		gObjectC.setVelocity(5);
		Type_B_GameObject gObjectB = new Type_B_GameObject(200,50,gObjectC);
		gObjectB.setDirection(1);
		gObjectB.setImage();
		gObjectB.setVelocity(5);
		Type_A_GameObject gObjectA = new Type_A_GameObject(50,20,gObjectB);
		gObjectA.setDirection(3);
		gObjectA.setImage();
		gObjectA.setVelocity(5);
		gObjectD.give(gObjectA);
		canvas.addGameObject(gObjectA);
		canvas.addGameObject(gObjectB);
		canvas.addGameObject(gObjectC);
		canvas.addGameObject(gObjectD);
		canvas.addKeyListener(gObjectD);
		canvas.setFocusTraversalKeysEnabled(false);
		
		 
		
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("pee");
		}
	}

}
