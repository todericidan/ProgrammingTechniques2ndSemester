package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ViewComponent{
	

	public void paintComponent(JPanel panel)
	{
		//g = p.getGraphics();
		Graphics g =(Graphics)panel.getGraphics();
		g.setColor(Color.BLUE);
		g.fillOval(10, 15, 100, 100);
		System.out.println("ddd");
		
		
		
	}

}
