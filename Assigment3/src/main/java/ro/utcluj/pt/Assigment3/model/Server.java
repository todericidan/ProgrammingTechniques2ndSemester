package ro.utcluj.pt.Assigment3.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Server implements Runnable {

	private BlockingQueue<Task> blockingQueue;
	private LinkedList<Task> proccessedTasks = new LinkedList<Task>();
	/*pentru generare de
	avg waiting time(cat astepti pana la procesare) adica diferenta willStartProcessingTime - creationTime
	si service avg time(cat ia fiecare task in parte sa fie procesat) ProcessTime
	 */
	private AtomicInteger waitingTime;
	private int thresholdTime;//echivalent cu waitingTime-ul maxim
	private float avgWaitingTime,avgServiceTime;
	private long creationTime,terminationTime;
	private int id;
	private Task taskInProcess;


	public Server(int threshold,int id) {

		this.id = id;
		creationTime = System.currentTimeMillis();
		waitingTime= new AtomicInteger(0);
		blockingQueue = new LinkedBlockingQueue<Task>();
		thresholdTime = threshold;

	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public long getCreationTime()
	{
		return creationTime;
	}

	public long getTerminationTime()
	{
		return terminationTime;
	}

	private void computeAvgWaitingTime()
	{
		if(proccessedTasks.size()>0)
		{
			long sum =0;
			for(Task t:proccessedTasks)
			{
				sum = sum +(t.getIsGettingProccessedTime()-t.getCreationTime());
			}
			System.out.println("WTSum "+sum+" SIZE "+proccessedTasks.size());
			avgWaitingTime =(float) sum / proccessedTasks.size();

		}
	}

	public float getAvgWaitingTime()
	{
		return avgWaitingTime;
	}

	private void computeAvgServiceTime()
	{
		if(proccessedTasks.size()>0)
		{
			int sum =0;
			for(Task t:proccessedTasks)
			{
				sum = sum + t.getProcessTime();
			}
			System.out.println("STSum "+sum+" SIZE "+proccessedTasks.size());
			avgServiceTime = (float)sum / proccessedTasks.size();
		}
	}

	public float getAvgServiceTime()
	{
		return avgServiceTime;
	}


	public void run() 
	{

		for(Task tt: this.getTasks())
		{
			System.out.println("task "+tt.getProcessTime());
		}

		while (true) {

			Task t;
			try 
			{
				t = blockingQueue.take();
				t.startProcessing();
				taskInProcess = t;
				Thread.sleep(t.getProcessTime()*1000);
				proccessedTasks.add(t);
				waitingTime.addAndGet((-1) * t.getProcessTime());
				System.out.println("Server"+id+" has finished task "+t.getProcessTime());
				computeAvgWaitingTime();
				computeAvgServiceTime();

				//
				printAlreadyProccessedTasks();
				//

			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String generateStringOfProcessedTasks()
	{
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("SERVER "+id+":"+'\n');

		for(Task task:proccessedTasks)
		{
			stringBuilder.append(task.getProcessTime() +"- waited "+(task.getIsGettingProccessedTime()-task.getCreationTime())+" -"+" DONE!"+'\n');
		}
		stringBuilder.append("AvgWaiting "+getAvgWaitingTime()/1000+'\n');
		stringBuilder.append("Service Time "+getAvgServiceTime());

		return stringBuilder.toString();
	}


	private void printAlreadyProccessedTasks() {
		if(proccessedTasks.size()>0)
		{
			System.out.println(generateStringOfProcessedTasks());
		}

	}

	public boolean addTask(Task t) {
		
		if(!hasReachedThreshold())
		{
			System.out.println(id+" will process "+t.getProcessTime());
			blockingQueue.add(t);
			waitingTime.addAndGet(t.getProcessTime());
			return true;
		}
		System.out.println("Threshold reached"+ waitingTime.intValue());
		return false;
	}

	public Task[] getTasks(){

		Task[] task = new Task[blockingQueue.size()];
		blockingQueue.toArray(task);

		return task;
	}

	public int getWaitingTime()
	{
		return waitingTime.get();
	}


	public boolean hasReachedThreshold()
	{
		int aux = waitingTime.intValue();
		System.out.println(aux);
		if(aux >= thresholdTime)
		{
			return true;
		}
		return false;
	}

	public boolean isEmpty()
	{
		return blockingQueue.isEmpty();
	}


	public Task getTaskInProcess() {
		return taskInProcess;
	}


}
