

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import functionality.BankSerializer;
import model.Account;
import model.Bank;
import model.Person;
import model.SavingAccounts;


public class AppTest {

	private Bank bank;

	public AppTest()
	{
		setup();
	}

	@Before
	public void setup() {
		BankSerializer ser = new BankSerializer();

		File f = new File("C:\\Users\\T\\Desktop\\workspace\\Bank\\bank.ser");
		if(f.exists())
		{
			System.out.println("Restored bank");
			bank = ser.restoreBank();
			System.out.println(bank);
		}
		else
		{
			bank = new Bank();
		}

	}

	@Test
	public void addPersonTest()
	{
		Person p = new Person("Tode", 26);

		int preSize = bank.getAllPersons().size();

		bank.addAccforPerson(p, new SavingAccounts(1, 20));

		int postSize = bank.getAllPersons().size();

		assertEquals("AddPerson Check",preSize,postSize-1);

	}

	@Test
	public void addAccountTest()
	{
		Person p = new Person("Tode", 26);
		bank.addAccforPerson(p, new SavingAccounts(2, 20));

		int preSize = bank.getAllAccountsForPersons(p).size();

		//System.out.println("Pre "+preSize);

		bank.addAccforPerson(p, new SavingAccounts(1, 20));

		int postSize = bank.getAllAccountsForPersons(p).size();

		//System.out.println("Post "+postSize);
		assertEquals("AddAccount Check",preSize,postSize-1);
	}


	@Test
	public void depositMoneyTest()

	{
		Person p = new Person("Tode", 26);
		bank.addAccforPerson(p, new SavingAccounts(2, 20));

		int id = 2;

		int preSum = 0;

		Set<Account> accounts = bank.getAllAccountsForPersons(p);
		for (Account a:accounts)
		{
			if (a.getAccID() == id)
			{
				preSum = (int) a.getMoney();
			}
		}

		bank.depositMoney(30, 2, p);
		int postSum = 0;
		for (Account a:accounts)
		{
			if (a.getAccID() == id)
			{
				postSum = (int) a.getMoney();
			}
		}

		assertEquals(" Check",preSum,postSum-30);


	}


	@SuppressWarnings("deprecation")
	@Test
	public void withdrawMoney()
	{
		Person p = new Person("Tode", 26);
		bank.addAccforPerson(p, new SavingAccounts(2, 20));

		int id = 2;

		int preSum = 0;

		Set<Account> accounts = bank.getAllAccountsForPersons(p);
		for (Account a:accounts)
		{
			if (a.getAccID() == id)
			{
				preSum = (int) a.getMoney();
			}
		}

		bank.withdrawMoney(30, 2, p);
		int  postSum = 0;
		for (Account a:accounts)
		{
			if (a.getAccID() == id)
			{
				postSum = (int) a.getMoney();
			}
		}

		assertEquals(" Check",preSum,postSum+30);
	}


	@Test
	public void deleteAccountTest()
	{
		Person p = new Person("Tode", 26);
		bank.addAccforPerson(p, new SavingAccounts(2, 20));
		bank.addAccforPerson(p, new SavingAccounts(1, 20));

		int preSize = bank.getAllAccountsForPersons(p).size();

		//System.out.println("Pre "+preSize);
		bank.deleteAccount(1, p);

		int postSize = bank.getAllAccountsForPersons(p).size();

		//System.out.println("Post "+postSize);
		assertEquals("AddAccount Check",preSize,postSize+1);


	}

	@Test
	public void deletePersonTest()
	{
		Person p = new Person("Tode", 26);
		bank.addAccforPerson(p, new SavingAccounts(2, 20));

		int preSize = 1;

		bank.deletePerson(p);

		int postSize = 0;
		
		for(Person p1:bank.getAllPersons())
		{
			if(p1.equals(p))
			{
				postSize = 1 ;
			}
		}

		assertEquals("AddPerson Check",preSize,postSize-1);

	}



}
