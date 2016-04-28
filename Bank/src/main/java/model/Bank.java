package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Bank implements BankI,Serializable{
	

	private static final long serialVersionUID = -4340743820537006068L;
	
	private Map<Person,Set<Account>> record;

	public Bank(){
		record = new HashMap<Person,Set<Account>>();
	}

	public void addAccforPerson(Person p,Account assocAcc){

		//preCond
		assert IsWellFormed() : "Bank is not well formed";
		assert p!= null: "The person must not be null";
		assert assocAcc!=null: "The account must not be null";

		int preSize;

		if (record.containsKey(p)){
			preSize = record.get(p).size();
			record.get(p).add(assocAcc);

		}
		else{
			Set<Account> accounts = new HashSet<Account>(); 
			preSize =  0;
			accounts.add(assocAcc);
			record.put(p, accounts);
		}

		assocAcc.addObserver(p);

		int postSize = record.get(p).size();
		//postCond
		assert preSize ==postSize-1: "Account not added";//pe false iti pica in cazul ala e bine
		assert IsWellFormed(): "Bank is not well formed";

	}

	public void depositMoney(double sum,int accID,Person p)
	{

		//preCond
		assert (sum > 0): "Sum invalid";
		assert (accID>0): "Invalid id";
		assert p!= null: "The person must not be null";

		if (record.containsKey(p))
		{
			Set<Account> accounts = record.get(p);
			for (Account a:accounts)
			{
				if (a.getAccID() == accID)
				{
					a.addMoney(sum);
				}
			}
		}

		//postCond
		assert IsWellFormed(): "Bank is not well formed";

	}

	public void withdrawMoney(double sum, int accID, Person p) 
	{

		//preCond
		assert (sum > 0): "Sum invalid";
		assert (accID>0): "Invalid id";
		assert p!= null: "The person must not be null";

		if (record.containsKey(p))
		{
			Set<Account> accounts = record.get(p);
			for (Account a:accounts)
			{
				if (a.getAccID() == accID)
				{
					assert (a.getMoney()>=sum) :"Sum is greater than the money available";

					if(a.getMoney()>=sum)
					{
						a.withdrawMoney(sum);
					}

				}
			}
		}	
		//postCond
		assert IsWellFormed(): "Bank is not well formed";

	}

	public void deleteAccount(int accountID, Person p) 
	{	

		//preCond
		assert IsWellFormed() : "Bank is not well formed";
		assert p!= null: "The person must not be null";
		assert accountID>0: "The account must not be null";

		int preSize;

		if (record.containsKey(p))
		{
			preSize = record.get(p).size();

			Iterator<Account> iterator = record.get(p).iterator();
			while (iterator.hasNext()) 
			{
				if (iterator.next().getAccID() == accountID) 
				{
					iterator.remove();
				}

			}
		}
		else
		{
			preSize = 0;
		}


		int postSize = record.get(p).size();

		//postCond
		assert preSize == postSize +1 :"Account not deleted";
		assert IsWellFormed() : "Bank is not well formed";

	}

	public void deletePerson(Person p) 
	{
		//preCond
		assert IsWellFormed() : "Bank is not well formed";
		assert p!= null: "The person must not be null";
		int preSize;

		if(record.containsKey(p))
		{
			preSize = record.size();
			Set<Account> accounts = record.get(p);
			for (Account a:accounts)
			{
				record.get(p).remove(a);
			}

			record.remove(p);


		}
		else
		{
			preSize = 0;
		}

		int postSize = record.size();


		//postCond
		assert preSize == postSize +1 :"Person not deleted";
		assert IsWellFormed() : "Bank is not well formed";
	}

	public List<Person> getAllPersons() 
	{
		List<Person> listOfPersons = new ArrayList<Person>();

		for(Entry<Person,Set<Account>> entry: record.entrySet()) 
		{

			listOfPersons.add(entry.getKey());

		}

		return listOfPersons;
	}

	public Set<Account> getAllAccountsForPersons(Person p) 
	{
		Set<Account> listOfAccounts = record.get(p);
		return listOfAccounts;	

	}


	public boolean IsWellFormed(){
		for (Entry<Person,Set<Account>> entry:record.entrySet()){
			//System.out.println("intra:"+entry.getKey());
			if (entry.getValue() == null || entry.getValue().isEmpty()){
				return false;
			}
		}
		return true;
	}


	@Override
	public String toString() {
		return "Bank [records=" + record + "] \n";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		
		
		
		if (record == null) {
			if (other.record != null)
				return false;
		} else if (!record.equals(other.record))
			return false;
		return true;
	}


}
