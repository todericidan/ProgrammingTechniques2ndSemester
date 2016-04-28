package view;

import java.awt.BorderLayout;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import functionality.BankSerializer;
import model.Bank;
import model.Person;


public class AllPersonsTableView extends JFrame {
	
	private AllPersonsTablePanel panel;
	private List<Person> persons;
	
	public AllPersonsTableView()
	{
		persons = getPersons();
		panel = new AllPersonsTablePanel();
		panel.setData(persons);
		add(panel,BorderLayout.CENTER);
		
		// JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    //this.add(pane);
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
	}

	private List<Person> getPersons() 
	{
		Bank bank;
		BankSerializer ser = new BankSerializer();
		File f = new File("C:\\Users\\T\\Desktop\\workspace\\Bank\\bank.ser");
		if(f.exists())
		{
			System.out.println("success");
			System.out.println();
			System.out.println("Restored bank");
			bank= ser.restoreBank();
			System.out.println();
		}
		else
		{
			System.out.println("Setting Up Bank");
			bank = new Bank();
		}
		
		List<Person> personsList = bank.getAllPersons();
		return personsList;
	}

	
	

}
