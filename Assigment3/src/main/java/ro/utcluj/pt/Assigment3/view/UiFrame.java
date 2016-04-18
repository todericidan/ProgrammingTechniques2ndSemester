package ro.utcluj.pt.Assigment3.view;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ro.utcluj.pt.Assigment3.model.Scheduler;
import ro.utcluj.pt.Assigment3.model.Server;

public class UiFrame extends JFrame {

	private Scheduler scheduler;
	
	public UiFrame(Scheduler scheduler)
	{
		this.scheduler = scheduler;
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		JTextArea instructionsTextArea = new JTextArea(12,120);
		
		instructionsTextArea.setText(getTextFromServers());
		
		instructionsTextArea.setBounds(20,120,350,200);
		instructionsTextArea.setFont(new Font("Courier New", Font.ITALIC, 12));
		JScrollPane sp = new JScrollPane(instructionsTextArea);
		add(sp);
		
		setVisible(true);
		
	}

	private String getTextFromServers() 
	{
		StringBuilder stringBuilder = new StringBuilder("");
		for(Server s:scheduler.getServers())
		{
			stringBuilder.append(s.generateStringOfProcessedTasks()+'\n');
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		if(scheduler.getStartOfPeakHour()==-1)
		{
			stringBuilder.append('\n'+"No peak hour");
		}
		else
		{
			stringBuilder.append('\n'+"PeakHour: " +sdf.format(scheduler.getStartOfPeakHour())+" - "+sdf.format(scheduler.getFinishOfPeakHour()));
		}
		
		
		
		return stringBuilder.toString();
	}


	


}
