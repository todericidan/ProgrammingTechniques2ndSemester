package ro.utcluj.pt.Assigment3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ro.utcluj.pt.Assigment3.model.Scheduler;
import ro.utcluj.pt.Assigment3.model.Server;
import ro.utcluj.pt.Assigment3.model.Simulator;
import ro.utcluj.pt.Assigment3.model.Task;
import ro.utcluj.pt.Assigment3.view.ServerPanel;
import ro.utcluj.pt.Assigment3.view.UiFrame;

public class AppController implements Runnable{
	private Simulator simulator;
	private UiFrame userInterface;
	private int nbOfQueuesSpecified;
	private int thresholdSpecified;

	public AppController()
	{
		String nbOfQueues = JOptionPane.showInputDialog(null, "Insert Nb Of Queues", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(nbOfQueues);
		this.nbOfQueuesSpecified = Integer.parseInt(nbOfQueues);

		String threshold = JOptionPane.showInputDialog(null, "Insert Threshold", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(threshold);
		this.thresholdSpecified = Integer.parseInt(threshold);

		simulator = new Simulator(nbOfQueuesSpecified,thresholdSpecified);
		Thread thread = new Thread(simulator);
		thread.start();

		run();

	}

	public void run() {
		Scheduler scheduler = null ;
		while(simulator.isShopOpened())
		{

			scheduler= simulator.getScheduler();
			Task[] taskToBeSent = scheduler.getTasksYetToBeSent();

		}

		ArrayList<ServerPanel> panels = scheduler.getPanels();


		System.out.println("AM TRIMIS TOATE TASK-urile");
		while(!scheduler.areAllTasksDone())
		{

			ServerPanel panel = null;
			ArrayList<Server> listOfServers= scheduler.getServers();
			for(Server s : listOfServers)
			{
				panel =  panels.get(s.getId());
				panel.refreshData(s.getTasks());
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		System.out.println("GATA ");
		ServerPanel panel = null;
		ArrayList<Server> listOfServers= scheduler.getServers();
		for(Server s : listOfServers)
		{
			panel =  panels.get(s.getId());
			panel.refreshData(s.getTasks());
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		if(scheduler.getStartOfPeakHour()==-1)
		{
			System.out.println("No peak hour");
		}
		else
		{
			System.out.println("PeakHour: " +sdf.format(scheduler.getStartOfPeakHour())+" - "+sdf.format(scheduler.getFinishOfPeakHour()));
		}

		userInterface = new UiFrame(scheduler);

	}

}
