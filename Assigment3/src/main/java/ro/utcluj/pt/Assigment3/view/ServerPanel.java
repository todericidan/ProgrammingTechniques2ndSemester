package ro.utcluj.pt.Assigment3.view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.synth.SynthSpinnerUI;

import ro.utcluj.pt.Assigment3.model.Server;
import ro.utcluj.pt.Assigment3.model.ServerModel;
import ro.utcluj.pt.Assigment3.model.Task;

public class ServerPanel extends JPanel{
	
	private JList<Task> jtasks; 
	public ServerPanel(Server server)
	{
		jtasks = new JList<Task>(server.getTasks());		
		JScrollPane sp = new JScrollPane(jtasks);
		add(sp);
	}
	
	public void refreshData(Task[]list)
	{
		ServerModel model = new ServerModel();
		
		for (Task task : list)
		{
			   model.addElement(task);
		}
		
		jtasks.setModel(model);		
		
		repaint();
		revalidate();
	}

}
