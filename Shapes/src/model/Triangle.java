package model;

import java.awt.Canvas;
import java.awt.Graphics;



public class Triangle extends Shape {
	
	private int leftX;
	private int leftY;
	private int rightX;
	private int rightY;
	private int topX;
	private int topY;
	
	public Triangle(int id,int lx,int ly,int rx, int ry, int tx,int ty) {
		super(id);
		setLeftX(lx);
		setLeftY(ly);
		setRightX(rx);
		setRightY(ry);
		setTopX(tx);
		setTopY(ty);
	}


	

	@Override
	public void draw(Canvas canvas)
	{
		Graphics g = getG();
	}

	@Override
	public void moveUp() 
	{		
		setLeftY(getLeftY()-1);
		setRightY(getRightY()-1);
		setTopY(getTopY()-1);
	}

	@Override
	public void moveDown() {
		setLeftY(getLeftY()+1);
		setRightY(getRightY()+1);
		setTopY(getTopY()+1);
	}

	@Override
	public void moveRight() {
		setLeftX(getLeftX()+1);
		setRightX(getRightX()+1);
		setTopX(getTopX()+1);
	}

	@Override
	public void moveLeft() 
	{
		setLeftX(getLeftX()-1);
		setRightX(getRightX()-1);
		setTopX(getTopX()-1);		
	}

	@Override
	public float getArea() 
	{
		return 0;
	}




	public int getLeftX() {
		return leftX;
	}




	public void setLeftX(int leftX) {
		this.leftX = leftX;
	}




	public int getLeftY() {
		return leftY;
	}




	public void setLeftY(int leftY) {
		this.leftY = leftY;
	}




	public int getRightX() {
		return rightX;
	}




	public void setRightX(int rightX) {
		this.rightX = rightX;
	}




	public int getRightY() {
		return rightY;
	}




	public void setRightY(int rightY) {
		this.rightY = rightY;
	}




	public int getTopX() {
		return topX;
	}




	public void setTopX(int topX) {
		this.topX = topX;
	}




	public int getTopY() {
		return topY;
	}




	public void setTopY(int topY) {
		this.topY = topY;
	}



}
