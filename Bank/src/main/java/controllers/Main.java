package controllers;

import java.io.File;
import java.util.List;
import java.util.Set;

import functionality.BankSerializer;
import model.Account;
import model.Bank;
import model.Person;
import model.SavingAccounts;
import model.SpendingAccounts;
import view.UI;

public class Main {
	
	public static void main(String[] args) {
		
		
		Person p = new Person("Toma", 2);
		SpendingAccounts account = new SpendingAccounts(1, 1);
		SavingAccounts account2 = new SavingAccounts(1, 2);
		SpendingAccounts account1 = new SpendingAccounts(2, 1);
		SavingAccounts account3 = new SavingAccounts(2, 2);
		
		Person p1 = new Person("Toma", 2);
		
		System.out.println(p.equals(p1));
		System.out.println(account.equals(account1));
		Bank bank = new Bank();
		Bank bank1 = new Bank();
		bank.addAccforPerson(p, account);
		bank.addAccforPerson(p, account1);
		bank1.addAccforPerson(p, account2);
		bank1.addAccforPerson(p, account3);
		
		System.out.println(bank.equals(bank1));
		
		/*Bank bank = new Bank();
		Person p = new Person("Toma",2);
		bank.addAccforPerson(p,new SavingAccounts(1,300));
		bank.addAccforPerson(p, new SpendingAccounts(2,300));
		bank.depositMoney(100, 1, p);
		bank.withdrawMoney(2, 1, p);
		bank.depositMoney(100, 2, p);
		bank.withdrawMoney(2, 2, p);
		bank.addAccforPerson(p, new SpendingAccounts(3,300));
		
		p= new Person("Calin", 1);
		bank.addAccforPerson(p,new SavingAccounts(3,100));
		bank.addAccforPerson(p, new SpendingAccounts(4,300));
		bank.addAccforPerson(p, new SpendingAccounts(2,300));
		
		p = new Person("Marty", 3);
		bank.addAccforPerson(p, new SavingAccounts(3, 100));
		bank.addAccforPerson(p, new SavingAccounts(2, 100));
		bank.addAccforPerson(p, new SavingAccounts(1, 100));
		bank.deleteAccount(1, p);
		
		List<Person> list = bank.getAllPersons();
		
		System.out.println("people:");
		for(Person pp: list)
		{
			System.out.println(pp.toString());
		}
		System.out.println();
		
		Set<Account> accounts = bank.getAllAccountsForPersons(p);
		System.out.println("accounts:");
		for (Account a:accounts)
		{
			System.out.println(a.toString());
		}
		System.out.println();
		
		*/

		/*
		BankSerializer ser = new BankSerializer();
		
		File f = new File("C:\\Users\\T\\Desktop\\workspace\\Bank\\bank.ser");
		if(f.exists())
		{
		    System.out.println("success");
		    System.out.println();
			System.out.println("Restored bank");
			Bank bank1 = ser.restoreBank();
			System.out.println(bank1);
		}
		else
		{
		    System.out.println("fail");
		}
		
		
		//System.out.println(bank);
		
		//ser.serialiazeBank(bank);
		*/
		
		new UIController();

	}

}
