package ro.utcluj.pt.Assigment3.view;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class ServersFrame extends JFrame{

	private int startingX,startingY;
	private ArrayList<ServerPanel> listOfPanels = new ArrayList<ServerPanel>();
	private FlowLayout experimentLayout; 
	public ServersFrame()
	{
		super("SHOP");
		//System.out.println("FRAME");
		startingX=20;
		startingY=20;
		setSize(1500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		experimentLayout= new FlowLayout();
		setLayout(experimentLayout);
		
	}
	
	public void addPanel(ServerPanel panel)
	{
		System.out.println("add new panel");
		//panel.setBounds(startingX,startingY,100,100);
		//startingX = startingX + 325;
		listOfPanels.add(panel);
		
		add(panel);
		System.out.println("NB of Panels: "+listOfPanels.size());
		
		this.setVisible(true);	
		pack();
		repaint();
		revalidate();
		
	}

}
