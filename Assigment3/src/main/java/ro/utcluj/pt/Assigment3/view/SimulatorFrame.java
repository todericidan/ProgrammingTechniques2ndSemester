package ro.utcluj.pt.Assigment3.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import ro.utcluj.pt.Assigment3.model.Server;
import ro.utcluj.pt.Assigment3.model.Task;



public class SimulatorFrame extends JFrame {


	private ArrayList<Server> servers = new ArrayList<Server>();

	private JPanel panel = new JPanel();
	private int startingX,startingY;

	public SimulatorFrame() {
		super("SHOP");
		startingX=20;
		startingY=20;
		setSize(2000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel.setLayout(null);

		add(panel);

		setVisible(true);
	}

	public void displayData(ArrayList<Server>servers) {

		panel.removeAll();
		panel.revalidate();
		
		Iterator<Server> serverIterator = servers.iterator();
		
		while(serverIterator.hasNext())
		{
			System.out.println("UI SEVER"+serverIterator.next().getId());

			Task[] arrayOfTasks = serverIterator.next().getTasks();
			ArrayList<Task> listOfTasks = new ArrayList<Task>();

			for(Task t:arrayOfTasks)
			{
				listOfTasks.add(t);
			}
			Iterator<Task> taskIterator = listOfTasks.iterator();
			while(taskIterator.hasNext())
			{
				//Task auxTask = taskIterator.next();
				JButton button = new JButton(""+taskIterator.next().getProcessTime());
				button.setBounds(startingX, startingY, 50, 30);
				button.setBackground(Color.lightGray);
				panel.add(button);

				startingY = startingY+32;

			}

			JButton button = new JButton(""+serverIterator.next().getTaskInProcess().getProcessTime());
			button.setBackground(Color.green);
			button.setBounds(startingX, startingY, 50, 30);
			panel.add(button);

			startingX = startingX+40;
			startingY = 20;
		}


		panel.repaint();
		panel.revalidate();
	}
}

