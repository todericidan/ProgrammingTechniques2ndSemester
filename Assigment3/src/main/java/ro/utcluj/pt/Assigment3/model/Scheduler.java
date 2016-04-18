package ro.utcluj.pt.Assigment3.model;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;

import ro.utcluj.pt.Assigment3.view.ServerPanel;
import ro.utcluj.pt.Assigment3.view.ServersFrame;

public class Scheduler implements Runnable {
	// redistribui clienti la toate servere existente cand am un threshold
	private BlockingQueue<Task> taskList;
	// private BlockingQueue<Server> serversList;
	private ArrayList<Server> serversList;
	private int nbOfServers, threshold;
	private AtomicInteger idServer;
	private long startOfPeakHour,finishOfPeakHour,durationOfPeakHour;
	private long startOfPeakHourMax,finishOfPeakHourMax,durationOfPeakHourMax;
	//private SimulatorFrame frame = new SimulatorFrame();
	private ServersFrame frame;
	private ArrayList<ServerPanel> panels = new ArrayList<ServerPanel>();

	public Scheduler(int nbOfServers, int waitingTimeThreshold) 
	{
		frame = new ServersFrame();
		startOfPeakHour = - 1;
		finishOfPeakHour = - 1;
		startOfPeakHourMax = -1;
		finishOfPeakHour = -1;
		durationOfPeakHourMax = 0 ;
		idServer = new AtomicInteger(0);
		this.nbOfServers = nbOfServers-1;
		this.threshold = waitingTimeThreshold;
		taskList = new LinkedBlockingQueue<Task>();
		// serversList = new ArrayBlockingQueue<Server>(threshold);
		serversList = new ArrayList<Server>();
		Server server = new Server(waitingTimeThreshold, idServer.get());
		serversList.add(server);
		Thread thread = new Thread(server);// porneste threadul din primul Server
		thread.start();
	}

	public void run() {
		while (true) {	
			int size = taskList.size();
			if (size != 0) {
				// System.out.println(size);
				for (int i = 0; i < size; i++) {
					if (size == 0) {
						break;
					}
					int serverID = getAServerToDispatchOn();

					if (serverID != -1) {
						Task task = null;
						try 
						{
							task = taskList.take();
						} 
						catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Server server = serversList.get(serverID);
						server.addTask(task);
						size = taskList.size() - 1;
						
											
						ServerPanel panel;
						
						if(panels.size()<serverID+1)
						{
							panel = new ServerPanel(serversList.get(serverID));
							panels.add(panel);
							
							frame.addPanel(panel);
						}
						else
						{
							panel = panels.get(serverID);
						}
						
						for(Server s : serversList)
						{
							panel =  panels.get(s.getId());
							panel.refreshData(s.getTasks());
						}

						//panel.refreshData(serversList.get(serverID).getTasks());

					}
				}
			}
		}
	}
	public ServersFrame getFrame()
	{
		return frame;
	}

	public void putTaskInWaitingList(Task t) {
		taskList.add(t);
	}

	private int getAServerToDispatchOn() {

		boolean canBeDispatchedOn = false;

		for (Server s : serversList) {

			if (!s.hasReachedThreshold()) 
			{
				if(!(startOfPeakHour == -1))
				{
					finishOfPeakHour = System.currentTimeMillis();
					durationOfPeakHour = finishOfPeakHour-startOfPeakHour;
					if(durationOfPeakHourMax<durationOfPeakHour)
					{
						durationOfPeakHourMax = durationOfPeakHour;
						startOfPeakHourMax = startOfPeakHour;
						finishOfPeakHourMax = finishOfPeakHour;
						startOfPeakHour = -1;
						finishOfPeakHour = -1;
					}
				}


				canBeDispatchedOn = true;
				System.out.println("Can be sent to server " + s.getId());
				return s.getId();
			} 
			else 
			{
				System.out.println("Server " + s.getId() + " is full!");
			}
		}

		if (!canBeDispatchedOn && idServer.get() < nbOfServers) {
			System.out.println("A new server must be created!");
			this.idServer.addAndGet(1);

			Server server = new Server(this.threshold, idServer.get());

			Thread thread1 = new Thread(server);
			thread1.start();

			serversList.add(server);
			System.out.println("Can be sent to server " + server.getId());

			// System.out.println("Server " + s.getId() + " was to");

			return server.getId();
		} 
		else 
		{
			System.out.println("Cannot find server that has space left!");
			if(startOfPeakHour == -1)
			{
				startOfPeakHour = System.currentTimeMillis();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public ArrayList<ServerPanel> getPanels()
	{
		return panels;
	}

	public boolean areAllTasksDone()
	{


		if(taskList.isEmpty())
		{

			for (Server s : serversList) 
			{
				System.out.println("Server"+s.getId());
				for(Task t: s.getTasks())
				{
					System.out.println("Task"+t.getProcessTime());
				}

				if(!s.isEmpty())
				{
					return false;
				}
				else
				{
					System.out.println("Server "+s.getId()+" empty");
				}
			}
		}
		else
		{
			return false;
		}
		
		
		return true;
	}

	public Task[] getTasksYetToBeSent(){

		Task[] task = new Task[taskList.size()];
		taskList.toArray(task);

		return task;
	}

	public ArrayList<Server> getServers() {
		return this.serversList;
	}

	public long getStartOfPeakHour()
	{
		return startOfPeakHourMax;
	}

	public long getFinishOfPeakHour()
	{
		return finishOfPeakHourMax;
	}

}
