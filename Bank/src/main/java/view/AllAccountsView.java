package view;

import java.awt.BorderLayout;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import functionality.BankSerializer;
import model.Account;
import model.AllAccountsTabelModel;
import model.Bank;
import model.Person;
import model.SavingAccounts;



public class AllAccountsView extends JFrame{
	
	private AllAccountsPanel tablePanel;
	private LinkedList<Person> persons = new LinkedList<Person>();
	private LinkedList<Account> accounts = new LinkedList<Account>();
	
	public AllAccountsView()
	{
		setData();
		tablePanel = new AllAccountsPanel();
		tablePanel.setData(persons, accounts);
		add(tablePanel);
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}


	private void setData() 
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
		
		for(Person p:personsList)
		{
			
			Set<Account> personAccounts = bank.getAllAccountsForPersons(p);
			for(Account a:personAccounts)
			{
				this.persons.add(p);
				this.accounts.add(a);
				
			}
			
		}
		
		
		
		
	}
}
