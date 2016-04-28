package model;

import java.util.List;
import java.util.Set;

public interface BankI {
	
	//trebuie puse pre si post conditii pentru toate
	/**
	 * 
	 * @preCondition p!= NULL && account!= NULL
	 * @postCondition preSize accounts = postSize accounts -1
	 */
	public void addAccforPerson(Person p, Account acc);
	/**
	 * @preCondition sum > 0 && accID > 0 && p!=NULL
	 * @postCondition 
	 */
	public void depositMoney(double sum,int accID, Person p);
	
	/**
	 * @preCondition sum > 0 && sum<= account.money && accID > 0 && p!= NULL
	 * @postCondition  
	 */
	public void withdrawMoney(double sum,int accID,Person p);
	
	/**
	 * @preCondition p!= NULL && account!= NULL
	 * @postCondition preSize accounts = postSize accounts +1
	 */
	public void deleteAccount(int accountID,Person p);
	
	/**
	 * @preCondition p!= NULL 
	 * @postCondition preSize persons = postSize persons +1
	 */
	public void deletePerson(Person p);
	
	/**
	 * @return
	 */
	public List<Person> getAllPersons();
	
	/**
	 * @preCondition p!= NULL 
	 * @postCondition 
	 * @return
	 */
	public Set<Account> getAllAccountsForPersons(Person p);

}
