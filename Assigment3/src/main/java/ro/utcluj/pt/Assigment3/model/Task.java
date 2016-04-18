package ro.utcluj.pt.Assigment3.model;

import java.text.SimpleDateFormat;

public class Task {
	
	private int processTime;
	private long creationTime;
	private long isGettingProccessedTime;
	
	public Task(int taskTime)
	{
		processTime = taskTime;
		creationTime = System.currentTimeMillis();
	}
	
	public long getCreationTime()
	{
		return creationTime;
	}
	
	public long getIsGettingProccessedTime()
	{
		return isGettingProccessedTime;
	}
	
	public void startProcessing()
	{
		isGettingProccessedTime = System.currentTimeMillis();
	}
	
	
	public int getProcessTime()
	{
		return processTime;
	}
	
	@Override
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(creationTime);
		return "Arrival: "+formattedDate+" TaskTime:"+ processTime;
		
	}

}
