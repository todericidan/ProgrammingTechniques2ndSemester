package model;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class Rectangle extends Shape  {
	
	private int leftCornerX;
	private int leftCornerY;
	private int rightCornerX;
	private int rightCornerY;
	
	public Rectangle(int id,int lcX,int lcY, int rcX, int rcY) {
		super(id);
		setLeftCornerX(lcX);
		setLeftCornerY(lcY);
		setRightCornerX(rcX);
		setRightCornerY(rcY);
		
	}
	
	

	@Override
	public float getArea() {
		return getRightCornerX()-getLeftCornerX()*getRightCornerY()-getLeftCornerY();
	}

	@Override
	public void draw(Canvas canvas) {
		Graphics g = getG();
		
		//canvas.paint(new Graphics);
		
	}

	@Override
	public void moveUp() {
		setLeftCornerY(leftCornerY-1);
		setRightCornerY(rightCornerY-1);
		
	}

	@Override
	public void moveDown() {
		setLeftCornerY(leftCornerY+1);
		setRightCornerY(rightCornerY+1);
	}

	@Override
	public void moveRight() {
		setLeftCornerX(leftCornerX+1);
		setRightCornerX(rightCornerX+1);
		
	}

	@Override
	public void moveLeft() {
		setLeftCornerX(leftCornerX-1);
		setRightCornerX(rightCornerX-1);
		
	}

	public int getLeftCornerX() {
		return leftCornerX;
	}

	public void setLeftCornerX(int leftCornerX) {
		this.leftCornerX = leftCornerX;
	}

	public int getLeftCornerY() {
		return leftCornerY;
	}

	public void setLeftCornerY(int leftCornerY) {
		this.leftCornerY = leftCornerY;
	}

	public int getRightCornerX() {
		return rightCornerX;
	}

	public void setRightCornerX(int rightCornerX) {
		this.rightCornerX = rightCornerX;
	}



	public int getRightCornerY() {
		return rightCornerY;
	}



	public void setRightCornerY(int rightCornerY) {
		this.rightCornerY = rightCornerY;
	}



}
