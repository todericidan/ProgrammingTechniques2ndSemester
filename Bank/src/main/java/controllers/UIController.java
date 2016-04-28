package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import functionality.BankSerializer;
import model.Account;
import model.Bank;
import model.Person;
import model.SavingAccounts;
import model.SpendingAccounts;
import view.AllAccountsView;
import view.AllPersonsTableView;
import view.UI;

public class UIController implements ActionListener{
	private UI ui;
	private Bank bank;
	private BankSerializer ser = new BankSerializer();

	public UIController() {
		ui = new UI(this);

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
		System.out.println(bank);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonSource = (JButton) e.getSource();


		if(buttonSource.getText().equals("ADD"))
		{
			String person= JOptionPane.showInputDialog(null, "Insert Name", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(person);

			if(person.equals(""))
			{
				ui.displayMessage("Null name!");
				return;
			}

			String accountType= JOptionPane.showInputDialog(null, "Insert AccountType", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(accountType);

			if(accountType.equals(""))
			{
				ui.displayMessage("Null account type!");
				return;
			}

			if((!accountType.equals("Spending"))&&(!accountType.equals("Saving")))
			{
				ui.displayMessage("No matching type!");
				return;
			}

			String sum= JOptionPane.showInputDialog(null, "Insert StartingSum", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(sum);

			if(sum.equals(""))
			{
				ui.displayMessage("Null sum!");
				return;
			}

			if(!isNumeric(sum))
			{
				ui.displayMessage("Not a number!");
				return;
			}


			addPersonAndAccount(person,accountType,sum);
		}

		if(buttonSource.getText().equals("Deposit")|| buttonSource.getText().equals("Withdraw"))
		{
			String person= JOptionPane.showInputDialog(null, "Insert Name", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(person);

			if(person.equals(""))
			{
				ui.displayMessage("Null name!");
				return;
			}

			String accountID= JOptionPane.showInputDialog(null, "Insert AccountID", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(accountID);

			if(accountID.equals(""))
			{
				ui.displayMessage("Null account type!");
				return;
			}

			String sum= JOptionPane.showInputDialog(null, "Insert StartingSum", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(sum);

			if(sum.equals(""))
			{
				ui.displayMessage("Null sum!");
				return;
			}

			if(!isNumeric(sum))
			{
				ui.displayMessage("Not a number!");
				return;
			}

			if(buttonSource.getText().equals("Deposit"))
			{
				deposit(person,accountID,sum);
			}
			else
			{
				withdraw(person,accountID,sum);
			}
		}
		
		if(buttonSource.getText().equals("DeleteAcct"))
		{
			String person= JOptionPane.showInputDialog(null, "Insert Name", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(person);

			if(person.equals(""))
			{
				ui.displayMessage("Null name!");
				return;
			}

			String accountID= JOptionPane.showInputDialog(null, "Insert AccountID", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(accountID);

			if(accountID.equals(""))
			{
				ui.displayMessage("Null account type!");
				return;
			}
			
			deleteAccount(person,accountID);
		}
		
		if(buttonSource.getText().equals("DelPerson"))
		{
			String person= JOptionPane.showInputDialog(null, "Insert Name", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(person);

			if(person.equals(""))
			{
				ui.displayMessage("Null name!");
				return;
			}
			deletePerson(person);
		}
		
		if(buttonSource.getText().equals("SeePersons"))
		{
			new AllPersonsTableView();
		}
		
		if(buttonSource.getText().equals("SeeAccounts"))
		{
			new AllAccountsView();
		}
	

	}

	private void deletePerson(String person) {
		List<Person> list = bank.getAllPersons();

		int id=0;
		int foundPerson=0;


		for(Person pp: list)
		{
			if(pp.getName().equals(person))
			{
				id = pp.getId();
				foundPerson=1;
				break;
			}
		}

		if(foundPerson==1)
		{
			Person personToDelete = new Person(person, id);
			bank.deletePerson(personToDelete);
			changesCheck();
		}
		else
		{
			ui.displayMessage("No user has that name!");
		}
	}

	private void deleteAccount(String person, String accountID) {
		List<Person> list = bank.getAllPersons();

		int id=0;
		int foundPerson=0;


		for(Person pp: list)
		{
			if(pp.getName().equals(person))
			{
				id = pp.getId();
				foundPerson=1;
				break;
			}
		}

		if(foundPerson==1)
		{
			Person personToDeleteFrom = new Person(person, id);
			
			int accountId=Integer.parseInt(accountID);
			Set<Account> listOfAccounts =bank.getAllAccountsForPersons(personToDeleteFrom);
			
			double sumAvailable =0;
			int accountFound=0;
			for(Account a:listOfAccounts)
			{
				if(a.getAccID()==accountId)
				{
					accountFound=1;
					sumAvailable = a.getMoney();
					break;
				}
			}

			if(accountFound==1)
			{
				bank.deleteAccount(accountId, personToDeleteFrom);
				changesCheck();
			}
			else
			{
				ui.displayMessage("No account has that id!");
			}
		}
		else
		{
			ui.displayMessage("No user has that name!");
		}
		
	}

	private void withdraw(String person, String accountID, String sum)
	{
		List<Person> list = bank.getAllPersons();

		int id=0;
		int foundPerson=0;


		for(Person pp: list)
		{
			if(pp.getName().equals(person))
			{
				id = pp.getId();
				foundPerson=1;
				break;
			}
		}

		if(foundPerson==1)
		{
			Person personToUpdate = new Person(person, id);

			int accountId=Integer.parseInt(accountID);
			Set<Account> listOfAccounts =bank.getAllAccountsForPersons(personToUpdate);
			
			double sumAvailable =0;
			int accountFound=0;
			for(Account a:listOfAccounts)
			{
				if(a.getAccID()==accountId)
				{
					accountFound=1;
					sumAvailable = a.getMoney();
					break;
				}
			}

			if(accountFound==1)
			{
				double sumToWithdraw = Double.parseDouble(sum);
				if(sumToWithdraw>sumAvailable)
				{
					ui.displayMessage("Not enough money in account!");
				}
				else
				{
				bank.withdrawMoney(sumToWithdraw, accountId, personToUpdate);
				changesCheck();
				}
				
			}
			else
			{
				ui.displayMessage("No account has that id!");
			}
		}
		else
		{
			ui.displayMessage("No user has that name!");
		}
	}

	private void deposit(String person, String accountID, String sum) 
	{
		List<Person> list = bank.getAllPersons();

		int id=0;
		int foundPerson=0;


		for(Person pp: list)
		{
			if(pp.getName().equals(person))
			{
				id = pp.getId();
				foundPerson=1;
				break;
			}
		}

		if(foundPerson==1)
		{
			Person personToUpdate = new Person(person, id);

			int accountId=Integer.parseInt(accountID);
			Set<Account> listOfAccounts =bank.getAllAccountsForPersons(personToUpdate);
			
			//double sumAvailable =0;
			int accountFound=0;
			for(Account a:listOfAccounts)
			{
				if(a.getAccID()==accountId)
				{
					accountFound=1;
					//sumAvailable = a.getMoney();
					break;
				}
			}

			if(accountFound==1)
			{
				double sumToDeposit = Double.parseDouble(sum);
				bank.depositMoney(sumToDeposit, accountId, personToUpdate);
				changesCheck();
			}
			else
			{
				ui.displayMessage("No account has that id!");
			}
		}
		else
		{
			ui.displayMessage("No user has that name!");
		}
	}

	private void addPersonAndAccount(String person, String accountType, String sum) {
		List<Person> list = bank.getAllPersons();

		int id=0;
		int foundPerson=0;


		for(Person pp: list)
		{
			if(pp.getName().equals(person))
			{
				id = pp.getId();
				foundPerson=1;
				break;
			}
			else
			{
				if(pp.getId()>id)
				{
					id = pp.getId();
				}
			}
		}

		Person personToAdd;

		if(foundPerson==1)
		{
			personToAdd = new Person(person, id);
		}
		else
		{
			personToAdd = new Person(person, id+1);
		}

		System.out.println(personToAdd);

		int accountId=1;
		Account accountToAdd;

		if(foundPerson==1)
		{
			Set<Account> listOfAccounts =bank.getAllAccountsForPersons(personToAdd);

			for(Account a:listOfAccounts)
			{
				if(a.getAccID()>accountId)
				{
					accountId=a.getAccID();
				}
			}
			accountId++;
		}

		if(accountType.equals("Saving"))
		{
			accountToAdd = new SavingAccounts(accountId,Double.parseDouble(sum));
		}
		else
		{
			accountToAdd = new SpendingAccounts(accountId, Double.parseDouble(sum));
		}

		bank.addAccforPerson(personToAdd, accountToAdd);
		
		changesCheck();
	}


	private void changesCheck() {
		System.out.println("After change");
		System.out.println(bank);

		String choice= JOptionPane.showInputDialog(null, "Do you want to save changes? Y/N", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(choice);

		if(choice.equals("Y"))
		{
			System.out.println("SALVAM");
			ser.serialiazeBank(bank);
		}
		else
		{
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
		}
		
	}

	public static boolean isNumeric(String str)  
	{  
		try  
		{  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}


}
