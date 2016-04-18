package ro.utcluj.pt.Assigment3.model;

import ro.utcluj.pt.Assigment3.view.SimulatorFrame;

public class Simulator implements Runnable {

	int finishTime = 80; // 20:00 timer
	int maxProcessTime = 5;
	int minProcessTime = 1;
	private Scheduler scheduler;
	private boolean shopIsOpened;


	public Simulator(int nbOfQueues,int threshold) {
		shopIsOpened = true;
		scheduler = new Scheduler(nbOfQueues,threshold);
		Thread th = new Thread(scheduler);
		th.start();

	}

	public void run() {
		int currTime = 0;
		while (currTime < finishTime) 
		{
			currTime++; // +5 min
			int processTime = (int) (Math.random() * (maxProcessTime - minProcessTime) + minProcessTime);

			Task t = new Task(processTime);
			
			System.out.println("Created task "+processTime);

			scheduler.putTaskInWaitingList(t);

			try 
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{

				e.printStackTrace();
			}
			
		}
		shopIsOpened = false;
		
		
	
	}	
	public boolean isShopOpened()
	{
		return shopIsOpened;
	}
	
	public Scheduler getScheduler() {
		return scheduler;
	}
	
}
