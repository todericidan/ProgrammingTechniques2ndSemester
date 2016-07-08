package model;

import java.awt.Graphics;

import interfaces.Drawable;
import interfaces.Movable;

public abstract class Shape implements Movable,Drawable {
	
	public abstract float getArea();
	private Graphics g;
	
	public Shape(int id)
	{
		setId(id);
		setG(null);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}
	private int id;
	

}
