package model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;




public class Circle extends Shape {
	
	private int originX;
	private int originY;
	private int radius;
	
	public Circle(int id,int x, int y, int r)
	{
		super(id);
		setOriginX(x);
		setOriginY(y);
		setRadius(r);
		
	}

	@Override
	public void draw(Canvas canvas) {
		Graphics g = canvas.getGraphics();
        g.setColor(new Color(255, 0, 0));
        g.drawString("Hello", 200, 200);

		
//		g.setColor(Color.GREEN);
//		g.drawOval(originX, originY, radius+radius, radius+radius);
		
		//canvas.paint(g);
		//g.fillOval(x, y, width, height);
	}

	@Override
	public void moveUp() {
		setOriginY(getOriginY()-1);
		
		
	}

	@Override
	public void moveDown() {
		setOriginY(getOriginY()+1);
		
	}

	@Override
	public void moveRight() {
		setOriginX(getOriginX()+1);
		
	}

	@Override
	public void moveLeft() {
		setOriginX(getOriginX()-1);
		
	}

	@Override
	public float getArea() {
		return getRadius()*getRadius()*3.14f;
	}

	public int getOriginX() {
		return originX;
	}

	public void setOriginX(int originX) {
		this.originX = originX;
	}

	public int getOriginY() {
		return originY;
	}

	public void setOriginY(int originY) {
		this.originY = originY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
